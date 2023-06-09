package com.codeline.sampleProject.RequestObjects.GetEmployeeProject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAccountRequestObject {

    String bankName;

    Integer accountNumber;

    String bankBranch;
}
