package com.example.faceittest.controller;

import com.example.faceittest.mapper.EducationalInstitutionMapper;
import com.example.faceittest.model.dto.EducationalInstitutionRequestDto;
import com.example.faceittest.model.dto.EducationalInstitutionResponseDto;
import com.example.faceittest.service.EducationalInstitutionService;
import com.example.faceittest.service.SortService;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/models")
public class EducationalInstitutionController {
    private final EducationalInstitutionService educationalInstitutionService;
    private final EducationalInstitutionMapper educationalInstitutionMapper;
    private final SortService sortService;

    public EducationalInstitutionController(
            EducationalInstitutionService educationalInstitutionService,
            EducationalInstitutionMapper educationalInstitutionMapper,
            SortService sortService) {
        this.educationalInstitutionService = educationalInstitutionService;
        this.educationalInstitutionMapper = educationalInstitutionMapper;
        this.sortService = sortService;
    }

    @PostMapping("/upload")
    @ApiOperation(value = "upload csv file")
    public String uploadData(@RequestParam("file") MultipartFile file) throws Exception {
        List<EducationalInstitutionRequestDto> requestDtos = new ArrayList<>();
        InputStream inputStream = file.getInputStream();
        CsvParserSettings settings = new CsvParserSettings();
        settings.setHeaderExtractionEnabled(true);
        settings.setDelimiterDetectionEnabled(true);
        CsvParser parser = new CsvParser(settings);
        List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
        parseAllRecords.forEach(record -> {
            EducationalInstitutionRequestDto requestDto = new EducationalInstitutionRequestDto();
            requestDto.setState(record.getString("State"));
            requestDto.setName(record.getString("Name"));
            requestDto.setInstitutionType(record.getString("Institution Type"));
            requestDto.setPhoneNumber(record.getString("Phone Number"));
            requestDto.setWebsite(record.getString("Website"));
            requestDtos.add(requestDto);
        });
        educationalInstitutionService.saveAll(requestDtos
                .stream()
                .map(educationalInstitutionMapper::mapToModel)
                .collect(Collectors.toList()));
        return "Done !";
    }

    @GetMapping
    @ApiOperation(value = "get all data from db with pagination")
    public List<EducationalInstitutionResponseDto> findAll(
            @RequestParam(defaultValue = "20")
            @ApiParam(value = "default value: 20") Integer count,
            @RequestParam(defaultValue = "0")
            @ApiParam(value = "default value: 0") Integer page,
            @RequestParam(defaultValue = "id")
            @ApiParam(value = "default value: id") String sortBy) {
        Sort sort = Sort.by(sortService.parse(sortBy));
        PageRequest pageRequest = PageRequest.of(page, count, sort);
        return educationalInstitutionService.findAll(pageRequest)
                .stream()
                .map(educationalInstitutionMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
