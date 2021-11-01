package ru.odintsov.cbrf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class MoneyRate implements Serializable {

    private String numCode;
    private String charCode;
    private String nominal;
    private String name;
    private String value;
}
