package com.sleepwell.userapi.accommodation.service;

import com.sleepwell.userapi.accommodation.dto.AccommodationSearchDto;
import com.sleepwell.userapi.accommodation.entity.Accommodation;
import com.sleepwell.userapi.accommodation.repository.AccommodationCustomRepository;
import com.sleepwell.userapi.accommodation.repository.AccommodationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final AccommodationCustomRepository accommodationCustomRepository;

    public List<Accommodation> findAccommodation(AccommodationSearchDto accommodationSearchDto) {
        List<Accommodation> accommodations = accommodationCustomRepository.findAllByAccommodationSearchDto(accommodationSearchDto);

        if (accommodations.isEmpty()) {
            throw new RuntimeException("조건에 맞는 숙소가 존재하지 않습니다.");
        }
        return accommodations;
    }

    public Accommodation getAccommodation(Long accommodationId) {
        Optional<Accommodation> accommodation = accommodationRepository.findById(accommodationId);

        return accommodation.orElseThrow(() -> new RuntimeException("존재하지 않는 숙소입니다."));
    }
}
