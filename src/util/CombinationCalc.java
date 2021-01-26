package util;
import java.io.PrintStream;
import java.util.*;

public class CombinationCalc<T> {
	private void getSubsets(List<T> input, int length, int index, Set<T> currentSet, List<Set<T>> solution) {
		if (currentSet.size() == length) {
			solution.add(new HashSet<>(currentSet));
			return;
		}
		if (index == input.size()) {
			return;
		}
		T x = input.get(index);
		currentSet.add(x);
		getSubsets(input, length, index + 1, currentSet, solution);
		currentSet.remove(x);
		getSubsets(input, length, index + 1, currentSet, solution);
	}

	public List<Set<T>> getSubsets(List<T> input, int length) {
		List<Set<T>> solution = new ArrayList<>();
		getSubsets(input, length, 0, new HashSet<>(), solution);
		return solution;
	}

	public void printSolution(List<Set<T>> solution, PrintStream ps) {
		Iterator<Set<T>> solutionIterator = solution.iterator();
		ps.print("[");
		if (!solutionIterator.hasNext()) {
			ps.print("]");
		}
		while (solutionIterator.hasNext()) {
			Set<T> solutionEntry = solutionIterator.next();
			Iterator<T> setEntry = solutionEntry.iterator();
			ps.print("[");
			if (!setEntry.hasNext()) {
				ps.print("]");
			}
			while (setEntry.hasNext()) {
				T entry = setEntry.next();
				ps.print(entry);
				if (setEntry.hasNext()) {
					ps.print(", ");
				} else {
					ps.print("]");
				}
			}
			if (solutionIterator.hasNext()) {
				ps.print(", ");
			} else {
				ps.print("]");
			}
		}
		ps.println();
	}
}