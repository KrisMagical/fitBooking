package com.fitness.booking.Service;

import com.fitness.booking.Dto.CoachProfileDTO;
import com.fitness.booking.Dto.CoachSessionDTO;
import com.fitness.booking.Mapper.CoachMapper;
import com.fitness.booking.Mapper.CoachSessionMapper;
import com.fitness.booking.Model.CoachProfile;
import com.fitness.booking.Model.CoachSession;
import com.fitness.booking.Model.Enums.SessionStatus;
import com.fitness.booking.Repository.CoachProfileRepository;
import com.fitness.booking.Repository.CoachSessionRepository;
import com.fitness.booking.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoachService {

    private final CoachProfileRepository coachProfileRepository;
    private final CoachSessionRepository coachSessionRepository;
    private final UserRepository userRepository;
    private final CoachMapper coachMapper;
    private final CoachSessionMapper coachSessionMapper;

    @Transactional
    public CoachProfileDTO createOrUpdateProfile(String username, CoachProfileDTO dto) {
        Long userId = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("用户不存在"))
                .getId();

        CoachProfile profile = coachProfileRepository.findByUserId(userId)
                .orElseGet(() -> {
                    CoachProfile p = coachMapper.toEntity(dto);
                    p.setUserId(userId);
                    return p;
                });

        coachMapper.updateEntity(profile, dto);
        coachProfileRepository.save(profile);
        return coachMapper.toDto(profile);
    }

    @Transactional
    public CoachSessionDTO createSession(String username, CoachSessionDTO dto) {
        Long coachId = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("用户不存在"))
                .getId();

        CoachSession session = coachSessionMapper.toEntity(dto);
        session.setCoachId(coachId);
        session.setStatus(String.valueOf(SessionStatus.OPEN));
        coachSessionRepository.save(session);

        return coachSessionMapper.toDto(session);
    }

    public List<CoachSessionDTO> listMySessions(String username) {
        Long coachId = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("用户不存在"))
                .getId();

        return coachSessionRepository.findAllByCoachId(coachId)
                .stream()
                .map(session -> coachSessionMapper.toDto((CoachSession) session))
                .collect(Collectors.toList());
    }

    @Transactional
    public CoachSessionDTO updateSession(Long id, String username, CoachSessionDTO dto) {
        Long coachId = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("用户不存在"))
                .getId();

        CoachSession session = coachSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("时段不存在"));

        if (!session.getCoachId().equals(coachId)) {
            throw new RuntimeException("无权修改他人的时段");
        }

        coachSessionMapper.updateEntity(session, dto);
        coachSessionRepository.save(session);
        return coachSessionMapper.toDto(session);
    }
}
