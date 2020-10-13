/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Rafael
 */
public class Fornecedores extends Clientes {
    //Atributos
    public String CNPJ;
    
    //getters e setters

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
    //representa sobre a escrita / mudar comportamento de String / objeto com todos os dados - ( qualquer dado pode aparecer )
   @Override
   public String toString(){
       return this.getNome();
   }
}
