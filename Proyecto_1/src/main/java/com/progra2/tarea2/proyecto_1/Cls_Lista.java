package com.progra2.tarea2.proyecto_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author ASUS
 */
public class Cls_Lista {
    
    public static void main(String[] args) {
        {
            Random ale = new Random(); 
            int a = 1000;
            int sumaTotalV, sumEne = 0, sumFeb = 0, sumMar = 0, sumAbr = 0, sumaTotalMeses = 0;
            double porcentajes = 0.0, sumaTotalVC , isr, liquido;
            
            Cls_Vendedores ven;
            List<Cls_Vendedores> misEmp = new ArrayList();  // crear un Arreglo de lista donde setarán almacenados los datos
            List <String>nom = new ArrayList();
            nom.add("Donald");
            nom.add("Juan");
            nom.add("Carla");
            nom.add("Maria");
            nom.add("Hector");
            nom.add("Pedro");
            nom.add("Samuel");
            nom.add("David");

            for (int i = 0; i < 8; i++) {
                String n = nom.get(i);
                ven = new Cls_Vendedores(n);
                ven.setEnero(ale.nextInt(a));
                ven.setFebrero(ale.nextInt(a));
                ven.setMarzo(ale.nextInt(a));
                ven.setAbril(ale.nextInt(a));
                
                sumaTotalV = 0;
                sumaTotalV += ven.getEnero();
                sumaTotalV += ven.getFebrero();
                sumaTotalV += ven.getMarzo();
                sumaTotalV += ven.getAbril();
                ven.setTotalVentas(sumaTotalV);
                
                if(sumaTotalV <= 2000){ 
                    porcentajes = sumaTotalV * 0.20;
                    ven.setVeinte(porcentajes);
                }else if(sumaTotalV >= 2001){
                    porcentajes = sumaTotalV * 0.30;
                    ven.setTreinta(porcentajes);
                }
                
               sumaTotalVC = sumaTotalV + porcentajes;
               ven.setTotalVenCom(sumaTotalVC);
               
               isr = sumaTotalVC * 0.05;
               ven.setIsr(isr);
                
               liquido = sumaTotalVC - isr;
               ven.setLiquido(liquido);
               
                misEmp.add(ven);
            }

            System.out.println("Nombre \tEnero \tFebrero Marzo \tAbril \tVentasT   20%   30%     Total + Comisiones   ISR  \tLiquido");
            for (Cls_Vendedores v : misEmp){     
                System.out.print(v.getNombre());

                System.out.print("\t"+v.getEnero());
                System.out.print("\t"+v.getFebrero());

                System.out.print("\t"+v.getMarzo());

                System.out.print("\t"+v.getAbril());

                System.out.print("\t"+v.getTotalVentas());

                System.out.print("   \t"+String.format("%.2f", v.getVeinte()));

                System.out.print("\t"+String.format("%.2f", v.getTreinta()));

                System.out.print("\t    "+String.format("%.2f", v.getTotalVenCom()));

                System.out.print("\t    "+String.format("%.2f", v.getIsr()));

                System.out.print("\t"+String.format("%.2f", v.getLiquido()));
                System.out.println("");
                
                sumEne += v.getEnero();
                sumFeb += v.getFebrero();
                sumMar += v.getMarzo();
                sumAbr += v.getAbril();
                
                sumaTotalMeses = sumEne + sumFeb + sumMar + sumAbr;
            }
            
            System.out.println("");
            System.out.println("Suma Enero: "+sumEne);
            System.out.println("Suma Febrero: "+sumFeb);
            System.out.println("Suma Marzo: "+sumMar);
            System.out.println("Suma Abril: "+sumAbr);
            System.out.println("Suma de todos los Meses: "+sumaTotalMeses);
        }
    }
}