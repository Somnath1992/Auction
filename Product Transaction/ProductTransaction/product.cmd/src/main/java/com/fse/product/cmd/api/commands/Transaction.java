package com.fse.product.cmd.api.commands;

import com.fse.cqrs.core.commands.BaseCommand;
import com.fse.product.common.dto.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction extends BaseCommand {


    @Id
    @GeneratedValue
    private Long trx_ID;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String pin;
    private String phone;
  //  @NotNull (message="Email Id mandatory!")
   // @Email(message="Email not valid !")
    private String email;
   // @NotNull(message="Product ID mandatory !")
    private int productId;
    private BigDecimal bidAmount;
}
