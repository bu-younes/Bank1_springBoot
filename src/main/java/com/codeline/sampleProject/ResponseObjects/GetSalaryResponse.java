package com.codeline.sampleProject.ResponseObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetSalaryResponse {

    Double healthCareContribution;

    Double allowances;

    Double bonus;

    Double perDiem;

    public GetSalaryResponse(String healthCareContribution, String allowances, String bonus, String perDiem) {
    }
}
