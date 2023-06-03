package LessonsAboutTime;

import java.time.Duration;

/*
 * Классы Period и Duraction наследуются от java.time.temporal.TemporalAmount.
 * Имеют теже методы что и остальные  
 */
public class LessonAboutPeriodAndDuraction {

	public static void main(String[] args) {
		Duration duration = Duration.ofMinutes(332);
		System.out.println(duration);
	}

}
