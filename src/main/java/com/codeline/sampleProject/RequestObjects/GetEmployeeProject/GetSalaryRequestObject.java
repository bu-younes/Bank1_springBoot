package com.codeline.sampleProject.RequestObjects.GetEmployeeProject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetSalaryRequestObject {

    Double healthCareContribution;

    Double allowances;

    Double bonus;

    Double perDiem;
}
