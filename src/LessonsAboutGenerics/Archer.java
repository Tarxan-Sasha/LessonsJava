package LessonsAboutGenerics;

public interface Archer<A> {
	A getArrows(A numberOfArrows);
	void shotFromBow();
}
