package com.creativearts.bigdata.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author:zhoubh
 * @create:2018-11-17
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MoxiePhoneNo {
    @Id
    private String id;

    private String phoneNo;
}
