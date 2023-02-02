package application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Data de check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data de check-out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
				
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Enter Data to update the reservation: ");
			System.out.print("Data de check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
				
			reservation.updateDates(checkIn, checkOut);
			System.out.println(reservation);
			
		} 
		catch (ParseException e) {
			System.out.println("Invalid date Format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " 
					+ e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro não esperado");
		}

		
		
		sc.close();

	}

}
