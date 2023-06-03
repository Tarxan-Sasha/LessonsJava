package LessonsAboutTime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/* Все эти классы появились в Java 8 
 * 
 * LocalDate, LocalTime, LocalDateTime, Instant - эти классы для работы с датой и временем имплементируют интерфейс java.time.temporal.Temporal
 * Period и Duration импелментируют java.time.temporal.TemporalAmount
 * 
 * LocalDate - это класс который отображает время с годом месяцем и днем.
 * Для создания обьекта этого класса используеться методы of(year, month, day) и now() 
 * 1) of(year, month, day) - в параметры нужно вложить int числа в порядке(year, month, day)
 * так же можно вставить на место месяца(month) вместо int числа константы enum Month
 * 2) now - отображает и принимает текущие значения года, месяца и дня.
 * 
 * Для получения года, дня и месяца есть методы:
 * getYear(), getMonth(), getMonthValue(), getDayOfWeek(), getDayOfMonth(), getDayOfYear();
 * 
 * Метод with позвоялет изменить год, месяц и число.
 * withMonth(), withYear(), withDayOfMoth(), withOfYear();
 * 
 * С помощью методов isAfter(), isBefore(), equals(), можно сравнить времена
 * какой был позже, какой раньше равны ли. 
 * 
 * Так же можно узнать был ли год высокосным с помощью метода isLeapYear()
 * 
 * С помощью методов plus и minus можно добавить или отнять дни недели месяцы и годы:
 * plusYears(), plusMonths(), plusWeeks(), plusDays(), minusYears(), minusMonths(), minusWeeks(), minusDays();
 * 
 * LocalTime - это класс который отображает время с часом, минутами, секундами и наносекундами
 * Как и для LocalDate обькты можно создать с помощью методов of(hour, minute, seconds, nanoSeconds) и now() 
 * только для метода of, нужно вставлять часы, минуты, секунды и наносекунды.
 * 
 * В целом методы посторяються с LocalDate:
 * Для получения метод get()
 * Для изменения метод with()
 * Для сравнения isAfter(), isBefore(), equals()
 * Для добавления или отнимания plus() и minus()
 * Везде нужно довблять hour minute second nanoSecond, взависимости что нужно получить/изменить/добавить/отнять  
 * 
 * LocalDateTime - это класс свомещение LocalDate и LocalTime, и отображает он время с годом, месяцем, днем, часом, минутой, секундой, и наносекундой
 * Можно создать обьект с помощью методов of(year, month, day, hour, day, minute, second, nanosecond) и now()
 * Имеет все методы своих аналогов LocalDate и LocalTime
 * 
 * Instant - это класс который моделирует одну мгновенную точку на временной шкале дефолтная временная точка 1970 год январь.
 * Методы:
 * ofEpochMilli (длинная эпохаМилли) - Получает экземпляр Instant, используя миллисекунды эпохи 1970-01-01T00: 00: 00Z.
 * ofEpochSecond (длинная эпохаSecond) - Получает экземпляр Instant, используя секунды из эпохи 1970-01-01T00: 00: 00Z.
 * А также методы те же методы что и у других with() plus() minus() isAfter() isBefore()
 * 
 */
public class LessonAboutLocalDate {

	public static void main(String[] args) {
		
		// LocalDate
		LocalDate localDate = LocalDate.of(2001, 6, 7);
		LocalDate localDate1 = LocalDate.of(2001, Month.APRIL, 3);
		
		LocalDate localDate2 = LocalDate.now();
		
		System.out.println("Year: "+localDate.getYear()+" Month: "+localDate.getMonthValue()+" Day: "+localDate.getDayOfMonth());
		System.out.println("Year: "+localDate1.getYear()+" Month: "+localDate1.getMonthValue()+" Day: "+localDate1.getDayOfMonth());
	
		System.out.println(localDate.isAfter(localDate2));//Проверяет указанное ли время позже времени в скобочках
		System.out.println(localDate.isBefore(localDate2));//Проверяет указанное ли время раньше времени в скобочках
		System.out.println(localDate.equals(localDate2));//Првоеряет равны ли времена, ну обычный equals()
		System.out.println(localDate.isLeapYear());//Проверяет высокосный ли год
		
		localDate1 = localDate1.withDayOfMonth(25);
		System.out.println(localDate1);
		
		localDate1 = localDate1.minusYears(1);
		localDate1 = localDate1.plusMonths(4);
		localDate1 = localDate1.minusDays(24);
		
		System.out.println(localDate1);
		
		
		//LocalTime
		LocalTime localTime = LocalTime.of(1, 30, 20, 1);
		System.out.println(localTime);
		LocalTime localTime1 = LocalTime.now();
		System.out.println(localTime1);
		
		
		//LocalDateTime
		LocalDateTime localDateTime = LocalDateTime.of(2022, 3, 1, 2, 4, 3);
		LocalDateTime localDateTime1 = LocalDateTime.now();
		System.out.println(localDateTime1);
		
		
		//Instant
		Instant instant = Instant.now();
		System.out.println("Instant "+instant);
		
		Instant instant2 = Instant.ofEpochSecond(12);
		System.out.println("Instant.ofEpochSecond "+instant2);
		
		Instant instant1 = Instant.ofEpochMilli(3);
		System.out.println("Instant.ofEpochMilli "+instant1);
		
		
		
		
	}
}

















