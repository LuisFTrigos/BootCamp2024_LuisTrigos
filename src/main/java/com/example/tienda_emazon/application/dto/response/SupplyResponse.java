package com.example.tienda_emazon.application.dto.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplyResponse {

    private String supplyName;

    private String supplyDescription;

    private Long supplyAmount;

    private Long supplyPrice;

}
