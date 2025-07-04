// Copyright (c) 2025 Daniel de la Concepción Sáez
package com.dan232.pricer.postgresql;

import java.math.BigInteger;

public interface EanPriceProjection {
    BigInteger getEan();
    double getMinPrice();
}
