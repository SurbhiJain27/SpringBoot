package com.egen.entity;

import lombok.Data;

//this class is not linked with table in database. It's just VO.
@Data
public class ItemQuantity {
    int itemId;
    int itemQuantity;
}
