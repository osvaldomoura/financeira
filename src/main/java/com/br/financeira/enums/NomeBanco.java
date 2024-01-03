package com.br.financeira.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NomeBanco {

    BDB("Banco do Brasil"),
    BBA("Banco Banrisul"),
    BCB("Banco C6 Bank"),
    BOC("Banco Olé Consignado"),
    BAS("Banco Safra"),
    FAF("Facta Financeira"),
    NSF("Novo Saque Financeira"),
    BMG("Banco BMG"),
    BAC("Banco Crefaz"),
    IT("Banco Itaú Consignado"),
    BPA("Banco Pan"),
    BRB("BRB - Crédito"),
    FOX("Fox Digital"),
    BRA("Banco Bradesco"),
    BDA("Banco Daycoval"),
    BMA("Banco Master"),
    BQC("Banco Quero Mais Crédito"),
    CCS("Capital Consig SCD S.A"),
    ICF("Icred Financeira");

    private final String descricao;
}
