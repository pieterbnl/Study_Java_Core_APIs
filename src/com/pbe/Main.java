package com.pbe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/** Study on Java core APIs
 @author Pieter Beernink
 @version 1.0
 @since 1.0
 */

public class Main {

    public static void main(String[] args) {

        // *********************
        // ArrayList
        // *********************
        // get -- public E get(int index)
        // Returns element at the specified position in the arraylist
        // Throws IndexOutOfBoundsException if the index is out of range
        //
        // set -- public E set(int index, E element)
        // Adds a new element at the specified position by replacing existing element at that position
        // Returns the element previously at the specified position
        // Throws IndexOutOfBoundsException if the index is out of range
        //
        // add -- arraylist.add(E element) & arraylist.add(int index, E element)
        // Adds a new element at the specified position, shifting existing element towards to the right
        // Returns true if the element is successfully inserted
        // Throws IndexOutOfBoundsException if the index is out of range
        // Appends the specified element to the end of the arraylist, if no index is provided
        //
        // addAll -- public boolean addAll(Collection<? extends E> c)
        // APPENDS all elements in the specified collection to the end of the arraylist,
        // in the order as returned by the specified collection's Iterator
        // Modifying the list during this operation may result in undefined behavior
        // Returns true if this list changed as a result of the call
        // Throws NullPointerException if the specified collection is null
        //
        // addAll -- public boolean addAll(int index, Collection<? extends E> c)
        // INSERTS elements in the specified collection into the arraylist, at the specified index
        // Shifts the existing element(s) at that position to the right.
        // Elements will appear in the list in the order as returned by the specified collection iterator.
        // Returns true if this list changed as a result of the call
        // Throws IndexOutOfBoundsException if the index is out of range
        //
        // remove -- public E remove(int index)
        // Removes the element at the specified position in arraylist, shifting existing elements towards to the left
        // Returns the element that was removed from the list
        // Throws IndexOutOfBoundsException if the index is out of range
        //
        // clear - public void clear()
        // Removes all elements from arraylist, resulting in an empty list
        //
        // removeAll - public boolean removeAll(Collection<?> c)
        // Removes from this list all of its elements that are contained in the specified collection
        // Returns true if list changed as a result of the call
        // Throws ClassCastException if the class of an element of this list is incompatible with (optional) specified collection
        // Throws NullPointerException if list contains a null element and (optional) specified collection is null or
        // does not permit null elements
        //
        // retainAll - public boolean retainAll(Collection<?> c)
        // Retains only the elements in the arraylist as contained in the specified collection
        // I.e.: removes all other elements from the list
        // Returns true if list changed as a result of the call
        // Throws same exceptions as removeAll
        //
        // removeRange - protected void removeRange(int fromIndex, int toIndex)
        // Removes from arraylist all elements whose index is between fromIndex (inclusive) and toIndex (exclusive).
        // Any succeeding elements are shifted to the left.
        // Throws IndexOutOfBoundsException if the index is out of range
        // removeRange() is protected, meaning it can only be accessed within the class/package/subclass
        // Rather than extending main with ArrayList<>, it's better to use ArrayList subList() and ArrayList clear() methods instead:
        // yourarray.subList(fromIndex, toIndex).clear();
        //
        // removeIf - public boolean removeIf(Predicate<? super E> filter)
        // Removes all elements from the arraylist that satisfy the specified condition (Predicate)
        // removeIf() method takes the single parameter filter, indicating which element is to be removed
        // Returns true if any elements were removed from the arraylist
        // Errors or runtime exceptions thrown during iteration or by the predicate are relayed to the caller
        //
        // replaceAll - public void replaceAll(UnaryOperator<E> operator)
        // Replaces each element of arraylist with the result with the result specified by the parameter
        // Operator specifies the operation to be applied to each element
        // This method does not return any values: it replaces all values of the list with new values from operator
        //
        // sort - public void sort(Comparator<? super E> c)
        // Sorts elements in an arraylist according to the specified order (Comparator)
        // All elements in this list must be mutually comparable using the specified comparator
        // That is: c.compare(e1, e2) must not throw a ClassCastException for any elements e1 and e2 in the list
        // The sort() method does not return any value: it only changes the order of elements in the list
        // The comparator interface provides several sorting methods, such as ascending and descending order
        // Note: Collections.sort() method is a more convenient method for sorting arraylists
        //
        // ensureCapacity() - public void ensureCapacity(int minCapacity)
        // Sets the size of an arraylist with the specified capacity, ensuring it can hold minimum specified number of elements
        // Takes a single parameter minCapacity: the specified minimum capacity of the arraylist
        // ArrayList dynamically resizes when adding elements, however:
        // An application can increase the capacity of an ArrayList instance before adding a large number of elements,
        // using the ensureCapacity operation. This may reduce the amount of incremental reallocation.
        // The working of ensureCapacity() is not visible to the user
        //
        // trimToSize() - public void trimToSize()
        // Trims capacity of ArrayList instance to be the list's current size, minimizing its storage
        // The trimToSize() method does not return any value, it only changes the capacity of the arraylist.
        // Note: Java ArrayList uses an array to store all its elements. When, at some point, the array is filled:
        // - a new array is created with 1.5 times more capacity than the current array.
        // - all elements are moved to the new array.
        // This results in unassigned space in the internal array, which is removed by using trimToSize()
        // The working of trimToSize() is not visible to the user
        //
        // size() - public int size()
        // Returns the no. of elements in the arraylist
        //
        // isEmpty - public boolean isEmpty()
        // Returns true if the arraylist contains no elements.
        //
        // Contains - public boolean contains(Object o)
        // Checks if the specified element is present in the arraylist
        // Returns true if the arraylist contains the specified element
        // That is, if and only if, the arraylist contains at least one element e
        // such that (o==null ? e==null : o.equals(e)).
        //
        // indexOf - public int indexOf(Object o)
        // Returns the position of the specified element in the arraylist
        // Returns -1 if the list does not contain the element
        //
        // lastIndexOf - public int lastIndexOf(Object o)
        // Returns the index of the last occurrence of the specified element in the arraylist
        // Or -1 if this list does not contain the element
        //
        // clone - public Object clone()
        // Returns a shallow copy of this ArrayList instance: elements themselves are not copied
        // Note: A shallow copy copies the references and a deep copy the values.
        //
        // toArray - public Object[] toArray()
        // Converts an arraylist into an array and returns it
        // All elements in the array are in sequence from first to last element as in the list
        // This method allocates a new array, meaning no references to it are maintained by this list.
        // This method acts as bridge between array-based and collection-based APIs
        // The toArray() method can take a single parameter: arraylist.toArray(T[] arr)
        // With T specifying the type of the array
        // I.e. toArray() returns an Array of type T or type Object, if no parameter is passed
        //
        // listIterator - public ListIterator<E> listIterator(int index)
        // Returns a list iterator over the elements in this list, starting at the specified position in the list
        // The specified index indicates the first element that would be returned by an initial call to 'next'
        // An initial call to 'previous' would return the element with the specified index, minus one
        // The list is returned in 'proper sequence': in order from the first to tje last element
        // Throws IndexOutOfBoundsException if the index is out of range
        // Note: the returned list iterator is 'fail-fast', Meaning that if there is
        // a structural modification (addition or removal of any element)
        // of the collection while a thread is iterating over that collection,
        // a ConcurrentModificationException will be thrown immediately.
        //
        // iterator - public ListIterator<E> listIterator()
        // Returns an iterator to access each element of the arraylist in a proper sequence (first to last)
        // The iterator() method does not take any parameters.
        // The iterator returned by the method is stored in the variable of the interface Iterator type
        //
        // subList - public List<E> subList(int fromIndex, int toIndex)
        // Returns a view of an extracted portion of an arraylist, specified fromIndex (inclusive) and toIndex (exclusive).
        // If fromIndex and toIndex are equal, the returned list is empty
        // This method eliminates the need for explicit range operations
        // Operations that expects a list can be used as a range operation by passing a subList view instead of a whole list
        // The returned list supports all of the optional list operations
        // Also all of the algorithms in the Collections class can be applied to a subList
        // Throws IndexOutOfBoundsException if an endpoint index value is out of range
        // Throws IllegalArgumentException if the endpoint indices are out of order
        //
        // forEach - public void forEach(Consumer<? super E> action)
        // Performs given action for each element of the Iterable,
        // until all elements have been processed or the action throws an exception
        // Actions are performed in the order of iteration (if an order is specified)
        //
        // spliterator - public Spliterator<E> spliterator()
        // Creates a late-binding and fail-fast Spliterator over the elements in the arraylist

        // create ArrayList languages and add elements
        ArrayList<String> languages = new ArrayList<>();

        languages.add("Dutch");
        languages.add("English");
        languages.add("Python");
        languages.add("Java");

        // display contents of languages
        System.out.println("ArrayList languages:\n" + languages);
        System.out.println();

        // use of addAll() - create a copy of ArrayList languages
        ArrayList<String> languagesCopy = new ArrayList<>();
        languagesCopy.addAll(languages);

        // display contents of languages and languagesCopy
        System.out.println("ArrayList languagesCopy, after addAll():\n" + languages);
        System.out.println();

        // create another ArrayList of languages, languages2, and add elements
        ArrayList<String> languages2 = new ArrayList<>();
        languages2.add("Chinese");
        languages2.add("France");
        languages2.add("German");
        languages2.add("Spanish");

        // another use of addAll() - adding languages2, at a given index
        languagesCopy.addAll(2, languages2);
        System.out.println("ArrayList languagesCopy, after addAll() languages2 at index 2:\n" + languagesCopy);
        System.out.println();

        // use of get() - display specific element of languages
        System.out.println("ArrayList languages.get(0): " + languages.get(0));
        System.out.println("ArrayList languages.get(3): " + languages.get(3));
        // System.out.println("ArrayList languages[4]: " + languages.get(4)); // will cause IndexOutOfBoundsException
        System.out.println();

        // use of set() - overwriting existing element at index 1
        languages.set(1, "Javascript");
        System.out.println("ArrayList languages, after set() Javascript:\n" + languages);
        System.out.println();

        // check return of set()
        System.out.println("Set() return, after set() Visual Basic, at index 1:\n" + languages.set(1, "Visual Basic"));
        System.out.println();

        // check languages again
        System.out.println("Current arraylist languages, after set() Visual Basic, at index 1:\n" + languages);
        System.out.println();

        // use of add() - adding element at index 1
        languagesCopy.add(1, "Javascript");
        System.out.println("ArrayList languagesCopy, after add() Javascript, at index 1:\n" + languagesCopy);
        System.out.println();

        // use of add(), without applying an index, adding element at end of arraylist
        languagesCopy.add("Pascal");
        System.out.println("ArrayList languagesCopy, after add() Pascal, without index:\n" + languagesCopy);
        System.out.println("ArrayList languages currently:\n" + languages);
        System.out.println();

        // use removeAll() - removing from languagesCopy, all languages as present in languages
        languagesCopy.removeAll(languages);
        System.out.println("ArrayList languagesCopy, after removeAll(languages):\n" + languagesCopy);
        System.out.println();

        // use of retainAll() - retaining from languagesCopy, only those languages as present in languages
        languagesCopy.retainAll(languages2);
        System.out.println("ArrayList languages2 currently:\n" + languages2);
        System.out.println("ArrayList languagesCopy, after retainAll(languages2):\n" + languagesCopy);
        System.out.println();

        // check languagesCopy size
        System.out.println("languagesCopy size(): " + languagesCopy.size());
        System.out.println();

        // clear languagesCopy array
        languagesCopy.clear();
        System.out.println("languagesCopy: " + languagesCopy);
        System.out.println();

        // check languagesCopy size, again
        System.out.println("languagesCopy size(), after clearing: " + languagesCopy.size());
        System.out.println();

        // use of removeRange() on languages2
        System.out.println("ArrayList languages2 currently:\n" + languages2);
        // languagesCopy.removeRange(1, 3); // protected method, requires to subclass the List implementation
        // alternative: list.subList(start, end).clear();
        // Note: clear() is called by removeRange behind the scenes
        languages2.subList(1,3).clear();
        System.out.println("ArrayList languages2, after sublist(1,3).clear():\n" + languages2);
        System.out.println();

        // use of removeIf() - remove any element that contains "Sp" (i.e.: removing Spanish)
        languages2.removeIf(e -> e.contains("Sp")); // using lambda expression
        System.out.println("ArrayList languages2, after removeIf(e -> e.contains(\"sp\"):\n" + languages2);
        System.out.println();

        // use of replaceAll() - changing all elements to uppercase
        System.out.println("ArrayList languages currently:\n" + languages);
        languages.replaceAll(e -> e.toUpperCase()); // changing everything to upper case
        languages.replaceAll(e -> e + 2); // adding 2 to each element
        System.out.println("ArrayList languages currently, after replaceAll():\n" + languages);
        System.out.println();

        // use of isEmpty()
        System.out.println("ArrayList languages is empty: " + languages.isEmpty());
        System.out.println("ArrayList languagesCopy is empty: " + languagesCopy.isEmpty());
        System.out.println();

        // Contains
        System.out.println("Is DUTCH2 present in the arraylist: ");
        System.out.println(languages.contains("DUTCH2"));
        System.out.println("Is dutch present in the arraylist: ");
        System.out.println(languages.contains("dutch"));
        System.out.println();

        // indexOf and lastIndexOf
        languages.add("JAVA2");
        languages.add("JAVA2");
        System.out.println("ArrayList languages currently:\n" + languages);
        System.out.println("Index of DUTCH2 in arraylist is: " + languages.indexOf("DUTCH2"));
        System.out.println("Index of python in arraylist is: " + languages.indexOf("python")); // not present in list
        System.out.println("First occurrence of JAVA2 is: " + languages.indexOf("JAVA2"));
        System.out.println("Last occurrence of JAVA2 is: " + languages.lastIndexOf("JAVA2"));
        System.out.println();

        // use of clone()
        // Note: applying typecasting, converting values returned by clone() into an arraylist of String type
        ArrayList<String> languagesClone = (ArrayList<String>) languages.clone();
        System.out.println("ArrayList languages currently:\n" + languages);
        System.out.println("ArrayList languagesClone currently:\n" + languagesClone);
        System.out.println();

        // use of sort() - sorting languages arraylist
        System.out.println("ArrayList languages, currently unsorted:\n" + languages);
        languages.sort(Comparator.naturalOrder()); // sorting in ascending order
        System.out.println("ArrayList languages, after sorting:\n" + languages);
        languages.sort(Comparator.reverseOrder()); // sorting in ascending order
        System.out.println("ArrayList languages, after sorting:\n" + languages);
        System.out.println();

        // use of toArray()
        // First create an array with the correct size
        // Then convert the arraylist into the array
        // And print out all elements of the array
        // String[] arr = new String[0]; // this would not work, as the array requires as length equal or bigger than the list
        String[] arr = new String[languages.size()];
        languages.toArray(arr); // passing an array of type String as an argument
        System.out.println("Array contents, after converting languages toArray(): ");
        for (String item : arr) System.out.print(item + ", ");
        System.out.println();
        System.out.println();

        // another use of toArray() - without parameter (not recommended)
        // String[] arr2 = (String[]) languages.toArray(); // this does not work, results in ClassCastException
        // for (String item : arr2) System.out.print(item + ", ");
        System.out.println("Array contents, after converting languages toArray() again: ");
        Object[] obj = languages.toArray(); // returning an array of objects
        for (Object item : obj) System.out.print(item + ", ");
        System.out.println();
        System.out.println();

        // using iterator to go through languages arraylist
        // First create an Iterator
        // Then loop through the list, using the iterator methods, until all elements are passed
        Iterator<String> iterate = languages.iterator();
        System.out.println("Iterating through the array, using an Iterator: ");
        while(iterate.hasNext()) {
            System.out.print(iterate.next());
            System.out.print(", ");
        }
        System.out.println();
        System.out.println();

        // forEach - iterating over arraylist
        System.out.println("Displaying items in languages arraylist, using forEach: ");
        languages.forEach((n) -> System.out.print(n + ", "));
        System.out.println();

    }
}
