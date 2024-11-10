package org.storpool.jsonanalysis.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Disk {
    @JsonProperty("id")
    private int id;

    @JsonProperty("model")
    private String model;

    @JsonProperty("serial")
    private String serial;
}
