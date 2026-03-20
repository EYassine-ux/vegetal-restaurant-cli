/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tp1prog;

import java.util.Scanner;

/**
 *
 * @author elkss
 */
public class Tp1Prog {
//capital constant

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Variables de contrôle et de quantités
        int i = 0;
        int choix = 0;
        int choix2 = 0;
        int quantite = 0;
        int quantiteDoubleVege = 0;
        int quantiteNouillesPoivrons = 0;
        int quantitePatatesPet = 0;
        int quantitePatatesMoy = 0;
        int quantiteBurger = 0;
        int quantiteSalade = 0;
         // Variables de prix pour chaque item commandé
        double prix1 = 0;
        double prix2 = 0;
        double prix3 = 0;
        double prix4 = 0;
        double prix5 = 0;
        double prix6 = 0;
        // Variables pour les calculs de facture
        double sousTotal;
        double rabais = 0;
        double tax = 0;
        double finalPrix = 0;
        // Constantes des prix des items
        final double PRIXDOUBLE = 5.5;
        final double PRIXNOUILLESPOIVRONS = 7.25;
        final double PRIXPATATESPET = 8.0;
        final double PRIXPATATESMOY = 12.0;
        final double PRIXBURGER = 7.0;
        final double PRIXSALADE = 6.0;
        final char CAD = '$';   // Symbole du dollar canadien   

        // Affichage du nom du restaurant
        System.out.println("***------<>------***");
        System.out.println("*     Végétal     *");
        System.out.println("***------<>------***");
        // Boucle principale pour les commandes
        do {
            // Boucle pour afficher le menu et traiter la commande            
            do {
                System.out.println("Choisir un item dans le menu");
                System.out.println("------------------------------");
                System.out.println("1. Le double végé                 " + PRIXDOUBLE + " " + CAD + " chacun");
                System.out.println("2. Nouilles aux quatre poivrons    " + PRIXNOUILLESPOIVRONS + " " + CAD + " chacun");
                System.out.println("3. Patates au four (Petite)        " + PRIXPATATESPET + " " + CAD + " chacune");
                System.out.println("4. Patates au four (Moyenne)       " + PRIXPATATESMOY + " " + CAD + " chacune");
                System.out.println("5. Le burger                       " + PRIXBURGER + " " + CAD + " chacun");
                System.out.println("6. Salade                          " + PRIXSALADE + " " + CAD + " chacune");
                
                // Vérification que l'utilisateur a commandé au moins un item pour afficher l'option 7 (facture)               
                if (choix > 0) {
                    System.out.println("7. Generer la facture ");
                }
                // Récupérer le choix de l'utilisateur
                System.out.print("choix : ");
                choix = scan.nextInt();
                
                // Validation du choix saisi pour gérer les erreurs                
                if (choix < 1 || choix > 7) {
                    System.out.println("Choix invalide, veuillez réessayer.");
                }
                // Si l'utilisateur choisit un item du menu (1-6), on demande la quantité
                if (choix > 0 && choix < 7) {
                    System.out.print("Quelle quantite :  ");
                    quantite = scan.nextInt();
                }
                // Enregistrement des quantités par item selon le choix
                switch (choix) {
                    case 1:
                        quantiteDoubleVege += quantite;
                        break;
                    case 2:
                        quantiteNouillesPoivrons += quantite;
                        break;
                    case 3:
                        quantitePatatesPet += quantite;
                        break;
                    case 4:
                        quantitePatatesMoy += quantite;
                        break;
                    case 5:
                        quantiteBurger += quantite;
                        break;
                    case 6:
                        quantiteSalade += quantite;
                        break;
                }              
            } while (choix != 7);  // Sortie de la boucle quand l'utilisateur veut générer la facture
             
            // Affichage de la facture                       
            System.out.println("Facture:");
            System.out.println("---------------------");
            
            // Calcul et affichage des sous-totaux pour chaque item commandé
            if (quantiteDoubleVege > 0) {
                prix1 = quantiteDoubleVege * PRIXDOUBLE;
                System.out.println("doubleVege x " + quantiteDoubleVege + "        " + prix1);
            }
            if (quantiteNouillesPoivrons > 0) {
                prix2 = quantiteNouillesPoivrons * PRIXNOUILLESPOIVRONS;
                System.out.println("nouillesPoivrons x " + quantiteNouillesPoivrons + "  " + prix2);
            }
            if (quantitePatatesPet > 0) {
                prix3 = quantitePatatesPet * PRIXPATATESPET;
                System.out.println("patatesPet x " + quantitePatatesPet + "        " + prix3);
            }
            if (quantitePatatesMoy > 0) {
                prix4 = quantitePatatesMoy * PRIXPATATESMOY;
                System.out.println("PatatesMoy x " + quantitePatatesMoy + "        " + prix4);
            }
            if (quantiteBurger > 0) {
                prix5 = quantiteBurger * PRIXBURGER;
                System.out.println("Burger x " + quantiteBurger + "            " + prix5);
            }
            if (quantiteSalade > 0) {
                prix6 = quantiteSalade * PRIXSALADE;
                System.out.println("Salade x " + quantiteSalade + "            " + prix6);
            }
            System.out.println("---------------------");
            
            // Calcul du sous-total
            sousTotal = prix1 + prix2 + prix3 + prix4 + prix5 + prix6;
            
            // Application du rabais selon le montant du sous-total
            if (sousTotal >= 100) {
                rabais = sousTotal * 0.1;
            } else if (sousTotal < 100 && sousTotal > 50) {
                rabais = sousTotal * 0.05;
            }
            
            // Calcul des taxes (14.975%)
            tax = sousTotal * 0.14975;
            
            // Affichage des détails de la facture            
            System.out.println("Sous-total: " + sousTotal + " " + CAD);
            System.out.println("Rabais: " + rabais + " " + CAD);
            System.out.println("TAXES: " + tax + " " + CAD);
            System.out.println("---------------------");
            
            // Calcul du prix final           
            finalPrix = sousTotal - rabais + tax;
            System.out.println("Prix final : " + finalPrix + " " + CAD);
            System.out.println("Choisir un item dans le menu");
            System.out.println("------------------------------");
            
            // Nouvelle commande ou quitter            
            do {
                System.out.println("1. Nouvelle commande");
                System.out.println("2. Quitter");
                choix2 = scan.nextInt();
            } while (choix2 != 2 && choix2 != 1);
            // Incrémentation du nombre de commandes           
            i++;
        } while (choix2 != 2);   // Sortie de la boucle quand l'utilisateur choisit de quitter
        
        // Affichage du résumé des commandes        
        System.out.println("Nombre de commandes aujoud'hui: " + i);
        System.out.println("---------------------------");
        
        if (quantiteDoubleVege > 0) {
            System.out.println("doubleVege x " + quantiteDoubleVege);
        }
        if (quantiteNouillesPoivrons > 0) {
            System.out.println("nouillesPoivrons x " + quantiteNouillesPoivrons);
        }
        if (quantitePatatesPet > 0) {
            System.out.println("patatesPet x " + quantitePatatesPet);
        }
        if (quantitePatatesMoy > 0) {
            System.out.println("PatatesMoy x " + quantitePatatesMoy);
        }
        if (quantiteBurger > 0) {
            System.out.println("Burger x " + quantiteBurger);
        }
        if (quantiteSalade > 0) {
            System.out.println("Salade x " + quantiteSalade);
        }
        System.out.println("---------------------------");
        System.out.println("Au revoir!!!!");
    }
}
