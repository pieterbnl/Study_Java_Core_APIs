package com.pbe;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

/** Study on Java core APIs
 @author Pieter Beernink
 @version 1.0
 @since 1.0
 */

public class Main {

    public static void main(String[] args) {

        // *********************
        // Arrays
        // *********************
        // See separate study on Arrays
        // Including: array creation, using a (multidimensional) array, sorting, searching, varargs

        // *********************
        // ArrayList
        // *********************
        // When creating an array it must be known how elements it will have to store
        // ArrayLists however can change size at runtime as needed
        // An ArrayList is an ordered sequence that allows duplicates
        // ArrayList requires an import: import java.util.ArrayList
        //
        // Three ways to create an ArrayList:
        // 1. ArrayList list1 = new ArrayList() // creates an ArrayList with default no. of slots (unfilled)
        // 2. ArrayList list2 = new ArrayList(x) // creates an ArrayList with x elements
        // 2. ArrayList list3 = new ArrayList(listx) // creates an ArrayList as copy of list listx
        //
        // Generics can be applied to ArrayList to enforce acceptance of a certain type only
        //
        // ArrayList implements interface List. I.e.: ArrayList is a List.
        //
        // ArrayLists can store any type, accept primitives
        // To store a primitive, it must be boxed in a wrapper class first:
        // - .valueOf() is used for converting a primitive to a type (boxing)
        // - .parseInt() (or any other relevant variant) for converting a type to a primitive (unboxing)
        // However, autoboxing has removed the need for these methods nowadays

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

        // create ArrayList languages
        ArrayList<String> languages = new ArrayList<>();

        // NOTE: ArrayList can also be created without specifying a type, as shown below.
        // In that case .get would return an element of type Object
        // ArrayList languages = new ArrayList();
        // languages.add("Dutch");
        // languages.add("English");
        // String element = languages.get(1); // would cause compilation failure as .get would return an Object type, not String type

        // use .add to add elements
        languages.add("Dutch");
        languages.add("English");
        languages.add("Python");
        languages.add("Java");

        // display contents of languages
        System.out.println("ArrayList languages:\n" + languages);
        System.out.println();

        // elements can also be added at a specific index
        languages.add(1, "Basic");
        // languages.add(10, "Basic"); // adding at an index that's out of bounds, will cause an IndexOutOfBoundsException
        System.out.println("ArrayList languages, after adding Basic:\n" + languages);
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

        // check return of set() - returning the contents of the element that has been replaced by set() (Javascript)
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

        // alternatively, using Collection's helper class 'sort':
        Collections.sort(languages);
        System.out.println("ArrayList languages, after sorting with Collections.sort:\n" + languages);
        System.out.println();

        // use of toArray() -to convert a list to an array- and Arrays.asList -to convert the array back to a list-
        // First create an array with the correct size
        // Then convert the arraylist into the array
        // And print out all elements of the array
        String[] arr = new String[languages.size()];
        // String[] arr = new String[0]; // would cause exception later on, as the array requires as length equal or bigger than the list
        // unless changing below to: arr = languages.toArray(arr) - in that case arr will be reassigned with the correct size

        languages.toArray(arr); // passing an array of type String as an argument
        System.out.println("Array contents, after converting languages toArray(): ");
        for (String item : arr) System.out.print(item + ", ");
        System.out.println();
        List<String> list = Arrays.asList(arr); // converts list back to an array
        System.out.println(arr[0]); // display an element from the array
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
        System.out.println();

        // *********************
        // Strings
        // *********************
        // Strings in Java are not primitive types like int, char, ...
        // Instead, Strings are objects of the predefined class String.
        // Hence, all string variables are instances of the String class
        // The String class is immutable: once a String object is created, it cannot be changed
        // Meaning it's size and contents are fixed
        // Even though String is immutable, it can still be used in a mutable class
        // A String instance variable can be made final
        // It's common to call multiple methods on the same String, i.e.: method chaining
        // For example: String result = "SoMe TexT   ".trim().toLowerCase().replace('a', 'A');
        //
        // length - public int length()
        // Returns the length of a string
        // The length is equal to the number of char values (code units) in the string
        //
        // concat - public String concat(String str)
        // Concatenates the specified string to the end of another string and returns it
        // The concat() method takes a single parameter: str, the string to be joined
        // It returns a string which is the concatenation of string and str (argument string)
        // Throws a NullPointerException if one of the strings is null
        // Note:
        // - that with concat() you can only pass a single String
        // - it's easier to use standard operators for concatenations, following these basic rules:
        // 1. If both operands are numeric, + means numeric addition
        // 2. If either operand is a String, + means concatenation
        // 3. The expression is evaluated from left to right
        //
        // charAt - public char charAt(int index)
        // Returns the character present at the specified index
        // An index ranges from 0 to length() - 1
        // The first char value is at index 0
        // Throws IndexOutOfBoundsException if index argument is negative or not less than the string length
        //
        // indexOf - public int indexOf(int ch)
        // Returns the index of the first occurrence of the specified character/substring (ch) within the string
        // Returns -1 if the character does not occur
        // Optionally, fromIndex can be passed, searching the ch character starting from this index (inclusive!)
        // Note that when an empty string is passed ("") as ch, 0 will be returned
        // This is because an empty string is a subset of every substring.
        // All characters are separated by an empty String and an empty String is present at the beginning and at the end?
        //
        // substring - public String substring(int beginIndex, int endIndex)
        // Returns the substring of a string, beginning with the character at the specified index (beingIndex)
        // Extending to the (optional) given index (endIndex), or if no endIndex is provided: the end of the string
        // An error will be given if:
        // - startIndex/endIndex is negative, or greater than the provided string's length
        // - startIndex is greater than endIndex
        //
        // toLowerCase/toUpperCase
        // Converts all characters in the string to lowercase/uppercase characters
        // Uses the rules of the given 'Locale' and is locale sensitive
        // May produce unexpected results if used for strings that are intended to be interpreted locale independently
        // Case mapping is based on the Unicode Standard version specified by the Character class
        // Note: Case mappings are not always 1:1 char mappings,
        // As a result, the resulting String may be of a different length than the original String
        //
        // equals - public boolean equals(Object anObject)
        // Compares string to the specified object
        // Returns true if two strings are equal: string.equals(String str)
        // Returns false if the strings are not equal or if String object to be compared is null
        // Note that equals() takes letter case into consideration
        // Use compareToIgnoreCase() method to ignore case differences
        //
        // equalsIgnoreCase
        // Compares this String to another String, ignoring case considerations
        // The strings are considered equal, ignoring case, if both:
        // 1. Are of the same length
        // 2. It's corresponding characters are equal
        // Returns true if the argument is not null, and it represents an equivalent String ignoring case
        //
        // startsWith - public boolean startsWith(String prefix, int toffset)
        // Checks if a given string begins with the specified string or not
        // Returns true if the string begins with the given string
        // The startsWith() method can take two parameters:
        // 1. prefix - check whether string starts with prefix or not
        // 2. offset (optional) - checks in a substring of string starting from this index
        // Note: startsWith() takes letter casing into consideration
        //
        // endsWith
        // Same as startsWith, but not for ending of a String
        // Returns true if the string ends with the given string
        //
        // replace - public String replace(CharSequence target, CharSequence replacement)
        // Replaces each matching occurrence of given character(s) in the string with given replacement character(s)
        // Returns the resulting String
        // Takes parameters:
        // 1. target - the sequence of characters to be replaced
        // 2. replacement - the replacement sequence of characters
        //
        // replaceAll - public String replaceAll(String regex, String replacement)
        // Replaces each substring of a string that matches the given regular expression with the given replacement
        // Returns the resulting String
        // Takes parameters:
        // 1. regex - the regular expression to which this string is to be matched
        // 2. replacement - the string to be substituted for each match
        // Throws PatternSyntaxException if the regular expression's syntax is invalid
        //
        // contains - public boolean contains(CharSequence s)
        // Returns true if a string contains the specified sequence of characters
        // Note: contains is a convenience method for str.indexOf(someString) != -1
        //
        // trim/strip - public String trim()/strip()
        // Strip and trim both removes any leading and trailing whitespaces
        // The difference is that strip also supports Unicode.
        // The strip method has been added in SE11
        // Note: whitespaces consists of spaces as well as: \t (tab) and \n (newline) characters
        //
        // stripLeading/stripTrailing - public String stripLeading()/stripTrailing()
        // Also added in SE11
        // stripLeading removes whitespace from the beginning of the String, leaving it at the end
        // stripLeading removes whitespace from the end of the String, leaving it at the beginning
        //
        // intern - public String intern()
        // Returns the value from the string pool (a canonical representation of the string object), if it's there
        // If not there, adds the value to the string pool
        // String interning ensures that all strings having the same contents use the same memory
        // For example if str1 and str2 both contain the contents "xyz" they will share the same memory
        // Instead, if 2 strings are created using the new keyword, they won't share the same memory
        // The latter is not considered equal, because they don't share the same memory
        //
        // getBytes - public byte[] getBytes()
        // Encodes a string into a sequence of bytes (using the platform's default charset), storing the result into a new byte array
        // Note: a Java String is internally stored as char[] (UTF-16 encoded)
        // Each char is 16 bits, and represents a Unicode character
        // The getBytes() allows to obtain a byte array for the string
        // The CharsetEncoder class should be used for more control over the encoding process
        //
        // compareTo - public int compareTo(String anotherString)
        // Compares two strings (in dictionary order)
        // The comparison is based on the Unicode value of each character in the strings
        //
        // format - public static String format(String format, Object... args) or format(Locale l, String format, Object... args)
        // Returns a formatted string, using the specified format string and arguments
        // Takes args parameter: arguments referenced by the format specifiers in the format string
        //  If there are more arguments than format specifiers, extra arguments are ignored
        //  The number of arguments is variable and may be zero
        // Throws IllegalFormatException if:
        // - a format string contains an illegal syntax
        // - a format specifier that is incompatible with the given arguments
        // - insufficient arguments given the format string
        // - other illegal conditions occur
        //
        // split - public String[] split(String regex)
        // Splits the string into an array of strings around matches of the given regular expression
        // This method works as if by invoking the two-argument split method with the given expression and a limit argument of zero
        // Trailing empty strings are therefore not included in the resulting array
        //
        // valueOf - public static String valueOf(Object obj)
        // Returns the string representation of the specified argument
        // If the argument is null, then a string equal to "null"
        // Otherwise, the value of obj.toString() is returned
        //
        // toCharArray - public char[] toCharArray()
        // Converts the string into a new character array

        // defining some strings to work with
        String myString0 = null;
        String myString1 = "";
        String myString2 = "This Aggression Will Not Stand, Man";
        String myString3 = "The Rug Pee-Ers Did Not Do This.";
        String myString4 = "Yeah, Well, That's Just, Like, Your Opinion, Man.";
        String myString5 = " ";
        String myString6 = "Hi\n";

        // use of length() - display the size of various strings
        // System.out.println("myString0 '" + myString0 + "' length is: " + myString1.length() + " characters"); // null String will cause NullPointerException
        System.out.println("myString1 '" + myString1 + "' length is: " + myString1.length() + " characters");
        System.out.println("myString2 '" + myString2 + "' length is: " + myString2.length() + " characters");
        System.out.println("myString5 '" + myString5 + "' length is: " + myString5.length() + " characters");
        System.out.println("myString6 '" + myString6 + "' length is: " + myString6.length() + " characters"); // note that \n (newline) is considered a single character
        System.out.println();

        // concatenation by use of operators
        System.out.println("myString2 is: " + myString2);
        System.out.println("myString4 is: " + myString4);
        String myString = myString2 + " - " + myString4;
        System.out.println("both strings concatenated, using operators: " + myString);

        // string concatenation with use of operators - combining numbers and Strings
        System.out.println(2 + 2); // 4
        System.out.println("hel" + "lo"); // hello
        System.out.println("hel" + "lo" + 007); // hello7
        System.out.println(222 + 222 + 222 + " degrees"); // 666 degrees
        System.out.println("feb" + 8 + 3); // feb83
        System.out.println();

        // use of concat - concatenating two strings
        System.out.println("myString2 is: " + myString2);
        System.out.println("myString4 is: " + myString4);
        System.out.println("both strings concatenated, using concat: " + myString2.concat(myString4));
        System.out.println();

        // use of charAt - return character from a given index in a string
        System.out.println("myString3 is: " + myString3);
        System.out.println("myString3 character at index 0: " + myString3.charAt(0));
        System.out.println("myString3 character at index 3: " + myString3.charAt(3));
        System.out.println("myString3 character at index 4: " + myString3.charAt(4));
        System.out.println("myString3 character at final index: " + myString3.charAt(myString3.length()-1));
        System.out.println();

        // use of indexOf - return index from a given character in a string
        myString = "Java rocks - 2021";
        // myString = null; // would cause NullPointerException
        System.out.println(myString);
        System.out.println("indexOf J: " + myString.indexOf("J")); // 0
        System.out.println("indexOf a: " + myString.indexOf("a")); // 1 - first occurrence of a
        System.out.println("indexOf  : " + myString.indexOf(" ")); // 4
        System.out.println("indexOf 2: " + myString.indexOf("2")); // 13
        System.out.println("indexOf 9: " + myString.indexOf("9")); // -1; as this character isn't present in the string
        System.out.println("indexOf : " + myString.indexOf("")); // 0; index of empty character in the string
        System.out.println("indexOf : " + myString.indexOf("a", 2)); // 3; - first occurrence of a, after index 2
        System.out.println("indexOf : " + myString.indexOf("a", 5)); // -1; no occurrences of a found after index 5
        System.out.println();

        // use of substring() - returning a substring from myString
        // based on a given starting index (inclusive) (and ending index (exclusive))
        System.out.println(myString); // Java rocks - 2021
        System.out.println("substring of index 0 until 4): " + myString.substring(0,4)); // Java - note: excludes index 4
        System.out.println("substring of index 4 until 5): " + myString.substring(4,5)); //
        System.out.println("substring of index 5 until 6): " + myString.substring(5,6)); // r
        System.out.println("substring of index 7 until 7): " + myString.substring(7,7)); // will return an empty string
        System.out.println("substring of index 5 until end): " + myString.substring(5)); // rocks - 2021 - note: no end index specified, means ending at the end of string
        System.out.println("substring of index 1 (from 'a') until 6): " + myString.substring(myString.indexOf('a'),6)); // ava r - note: using indexOf to grab the index of the first a
        // System.out.println("substring of index -5 until 5): " + myString.substring(-5, 5)); // given startindex is negative; will result in StringIndexOutOfBoundsException
        // System.out.println("substring of index 25 until end): " + myString.substring(25)); // given index is out of bounds; will result in StringIndexOutOfBoundsException
        // System.out.println("substring of index 10 until 5): " + myString.substring(10, 5)); // given startindex is higher than end index; will result in StringIndexOutOfBoundsException
        System.out.println();

        // use of toUpperCase and toLowerCase - converting string to upper case and lower case characters
        System.out.println("Original string: " + myString);
        System.out.println("String in upper case: " + myString.toUpperCase());
        System.out.println("String in lower case: " + myString.toLowerCase());
        System.out.println("Original string again: " + myString); // no changes where inflicted to the original string
        System.out.println();

        // example of effect of toLowerCase with changing locale - showing toLowerCase() is locale specific
        Locale.setDefault(new Locale("lt")); // setting Lithuanian as locale
        String str = "\u00cc";
        System.out.println("Before case conversion str is " + str + ", and it's length: " + str.length()); // Ì
        String lowerCaseStr = str.toLowerCase();
        System.out.println("After toLowerCase() str now is " + lowerCaseStr + ", and it's length: " + lowerCaseStr.length()); // i?`
        // Note: another method toLowerCase(Locale.English) may be used and override the locale to English always
        // However, then the application is not internationalized.
        System.out.println();

        // use of equals and equalsIgnoreCase
        String str1 = "Java rocks";
        String str2 = "Java rocks";
        String str3 = "The weather sucks";
        String str4 = "the weather sucks";
        String str5 = null;
        boolean result = str1.equals(str2);
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
        System.out.println("str3 = " + str3);
        System.out.println("str4 = " + str4);
        System.out.println("str5 = " + str5);
        System.out.println("str1 equals str2: " + result);
        System.out.println("str1 equals str3: " + str1.equals(str3));
        System.out.println("str3 equals str4: " + str3.equals(str4));
        System.out.println("str3 equals str4, using equalsIgnoreCase: " + str3.equalsIgnoreCase(str4));
        System.out.println("str1 equals 'Java rocks': " + str1.equalsIgnoreCase("Java rocks"));
        System.out.println("str1 equals str5: " + str1.equals(str5));
        System.out.println();

        // use of startsWith and endsWith
        System.out.println("myString3: " + myString3);
        System.out.println("myString3 starts with 'The': " + myString3.startsWith("The"));
        System.out.println("myString3 starts with 'the': " + myString3.startsWith("the")); // case sensitive
        System.out.println("myString3 ends with 'Do': " + myString3.endsWith("Do"));
        System.out.println("myString3 ends with 'This': " + myString3.endsWith("This"));
        System.out.println("myString3 ends with '.': " + myString3.endsWith("."));
        System.out.println("ABCDE starts with 'AB': " + "ABCDE".startsWith("AB"));
        System.out.println("myString3 starts with 'Rug', from index 4: " + myString3.startsWith("Rug", 4));
        System.out.println();

        // use of replace
        System.out.println("myString2: " + myString2);
        System.out.println("Replacing a's with e's: " + myString2.replace("a", "e")); // replace all a's with e's
        System.out.println("Replacing F's with G's: " + myString2.replace("F", "G")); // character not present - replace() will return the original string
        System.out.println("Replacing 'Will Not ' with nothing: " + myString2.replace("Will Not ", "")); // replacing a substring
        System.out.println("Replacing xx with y in string xxx: " + "xxx".replace("xx", "y"));
        System.out.println();

        // use of replaceAll
        String anotherStr = "Coding124Aint44325No1Cookie";
        String regex = "\\d+"; // note: \d is a regex to match a digit, + matches the preceding token (digit) one or more times
        System.out.println("anotherStr: " + anotherStr);
        System.out.println("Replacing all numeric digits with space: " + anotherStr.replaceAll(regex," "));
        System.out.println("myString2: " + myString2);
        System.out.println("replacing all 'an' with 'en': " + myString2.replace("an", "en"));
        System.out.println();

        // use of contains
        System.out.println("myString4: " + myString4);
        System.out.println("myString4 contains 'Well': " + myString4.contains("Well")); // true
        System.out.println("myString4 contains 'well': " + myString4.contains("well")); // false - case sensitive
        System.out.println("myString4 contains '': " + myString4.contains("")); // true
        System.out.println("ABCDE contains 'CD': " + "ABCDE".contains("CD")); // true
        System.out.println("ABCDE contains 'cd': " + "ABCDE".contains("cd")); // false
        String checkthis = "That";
        if (myString4.contains(checkthis)) {
            System.out.println(myString4 + " CONTAINS " + checkthis);
        } else {
            System.out.println(myString4 + " DOES NOT CONTAIN " + checkthis);
        }
        System.out.println();

        // use of trim/strip
        myString = "    It is what it is";
        System.out.println("myString: " + myString);
        System.out.println("myString length before trimming: " + myString.length());
        myString = myString.trim();
        System.out.println("myString after trimming: " + myString);
        System.out.println("myString length after trimming: " + myString.length());
        System.out.println();

        myString = "\n\n It is what it is";
        System.out.println("myString: " + myString);
        System.out.println("myString after trimming: " + myString.trim()); // \n is consider a whitespace
        System.out.println();

        myString = " abc\t";
        System.out.println("myString: " + myString);
        System.out.println("myString length before trimming: " + myString.length());
        myString = myString.trim();
        System.out.println("myString after trimming: " + myString);
        System.out.println("myString length after trimming: " + myString.length());  // \t is considered a single character
        System.out.println();

        // use of stripLeading/stripTrailing
        myString = " abc\t";
        System.out.println("myString: " + myString);
        System.out.println("myString length before stripLeading: " + myString.length());
        myString = myString.stripLeading();
        System.out.println("myString after stripLeading: " + myString);
        System.out.println("myString length after trimming: " + myString.length());
        System.out.println();

        // use of intern - returning a canonical representation of the string object
        String compareStr1 = "xyz";
        String compareStr2 = "xyz";
        System.out.println(str1 == str2); // true - both strings have the same contents and will share the same memory (Java automatically interns the string literals)

        String compareStr3 = new String("xyz");
        String compareStr4 = new String("xyz");
        System.out.println(compareStr3 == compareStr4); // false - not equal because these strings created with the new keyword don't share the same memory pool

        compareStr3 = compareStr3.intern();
        compareStr4 = compareStr4.intern();
        System.out.println(compareStr3 == compareStr4); // true - after applying the intern() method both strings share the same memory pool
        System.out.println();

        // use of getBytes - encoding a strings into a sequence of bytes and storing it in a byte array
        System.out.println("compareStr1 contents: " + compareStr1);
        byte[] byteArray;
        byteArray = compareStr1.getBytes();
        System.out.println("compareStr1 contents as bytes in array: " + Arrays.toString(byteArray));
        System.out.println();

        // use of compareTo - comparing two strings in the dictionary order (based on Unicode value of each character in the strings)
        compareStr1 = "Learn Java";
        compareStr2 = "Learn Python";
        compareStr3 = "Learn Java";
        //compareStr1 = "Learn Python";
        //compareStr2 = "Learn Java";
        System.out.println(compareStr1.compareTo(compareStr2)); // -6 - compareStr1 comes before compareStr2
        System.out.println(compareStr1.compareTo(compareStr3)); // 0 - strings are equal
        System.out.println();

        // format
        str = "Java";
        str2 = ", Right?";
        int number = 8;
        System.out.println(String.format("Hello %s", str)); // %s used for a string
        System.out.println(String.format("We love Java SE%x", number)); // %x used for integer
        System.out.println(String.format("We love Java SE%x %s", number, str2)); // combining multiple arguments
        System.out.println(String.format("It is %s %s %s", "what", "it", "is")); // combining multiple arguments
        System.out.println();

        // split - dividing a string at a specified regex and returning an array of substrings
        String text = "Java can be fun to learn";
        String[] resultArr = text.split(" "); // splitting string in substrings at every space, and storing each substring in an array element
        for (String element : resultArr) // looping through the elements and displaying its contents
            System.out.print(element + ", ");
        System.out.println();
        System.out.println();

        // use of valueOf - returning the string representation of a passed argument
        int a = 3;
        long l = -324L;
        float f = 231.3f;
        double d = 55.443d;
        char c = 'J';
        char ch[] = {'J', 'a', 'v', 'a'};
        System.out.println(String.valueOf(a));
        System.out.println(String.valueOf(l));
        System.out.println(String.valueOf(f));
        System.out.println(String.valueOf(d));
        System.out.println(String.valueOf(c)); // converting char to string
        System.out.println(String.valueOf(ch)); // converting char array to string
        System.out.println(String.valueOf(languages)); // converting object to string
        System.out.println();

        // use of toCharArray - converting a string tgo a char array
        System.out.println("myString2 converted to a char array: "); // Java Programming
        char[] somearray;
        somearray = myString2.toCharArray();
        System.out.println(somearray); // Java Programming
        for (char element : somearray) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println();

        // String method chaining example - combining several methods in one go
        System.out.println("SoMe TexT   ".trim().toLowerCase().replace('a', 'A'));
        System.out.println();


        // *********************
        // StringBuilder
        // *********************
        // Unlike the String class, StringBuilder is not immutable
        // StringBuilder objects are like String objects, except that they can be modified
        // The objects are treated Internally like var-length arrays that contain a sequence of characters
        // Length and content of the sequence can be changed through method invocations, at any point
        // When chaining StringBuilder objects, the StringBuilder changes its own state and returns a reference to itself
        //
        // The StringBuilder class provides no guarantee of synchronization whereas the StringBuffer class does
        // This class is designed for use as a drop-in replacement for StringBuffer
        // in places where the StringBuffer was being used by a single thread (generally the case)
        // Instances of StringBuilder are not safe for use by multiple threads
        // If such synchronization is required then it is recommended that StringBuffer be used
        //
        // StringBuilder should only be used when it offers a coding or performance advantage
        // For example when concatenating a large number of Strings
        // Even when using StringBuilder, the end result typically needs to be a String (using toString() for conversion)
        //
        // StringBuilder has several constructors, of which one is: StringBuilder(int capacity)
        // By providing a 'capacity', StringBuilder reserves a certain number of slots for characters
        // Other constructors:
        // - StringBuilder() - string builder with no characters in it and an initial capacity of 16 characters
        // - StringBuilder(CharSequence seq) - string builder that contains the same characters as the specified CharSequence
        // - StringBuilder(String str) - string builder initialized to the contents of the specified string
        //
        // NOTE:
        // - Size is the number of characters currently in the sequence
        // - Capacity is the number of characters the sequence can currently hold
        // - With String, being immutable, size and capacity are the same
        // - With StringBuilder, being mutable, Java gives it a default capacity of 16 or of choosing
        //
        // StringBuilder has several methods that work exactly the same as String:
        // charAt(), indexOf(), length(), substring()
        // Note that substring() returns a String, and not a StringBuilder
        // Substring() is just a method to inquire about where a substring happens to be
        //
        // Other methods:
        //
        // - append() - StringBuilder append(String str)
        // Most frequently used StringBuilder method
        // Adds the parameters to the StringBuilder and returns a reference to current StringBuilder object
        // Has a large number of different constructors, for appending different kind of string representations
        // For boolean arguments, char arguments, char array arguments, subarray of char array argument, etc.
        //
        // - insert() - StringBuilder insert(int offset, String str)
        // Add characters to a StringBuilder at the requested index (offset) and returns a reference to current StringBuilder
        // When inserting a character or string, all elements above that position will be shifted by the length of the argument
        // If str is null, then the four characters "null" are inserted into this sequence
        // The offset argument must be greater than or equal to 0, and less than or equal to the length of this sequence
        // Throws StringIndexOutOfBoundsException if the offset is invalid.
        // Like append(), insert() also has lots of method signatures for different types
        // Including: public StringBuilder insert(int dstOffset, CharSequence s, int start, int end)
        // Inserts a subsequence of the specified CharSequence into this sequence
        //
        // delete() - public StringBuilder delete(int start, int end)
        // Opposite of insert method: removes characters from a sequence and returns a reference to current StringBuilder
        // Substring begins at the specified start and extends to the character at index end - 1
        // or to the end of the sequence if no such character exists
        // If start is equal to end, no changes are made
        // Throws StringIndexOutOfBoundsException if start is negative, greater than length(), or greater than end
        //
        // deleteCharAt() - public StringBuilder deleteCharAt(int index)
        // This method is convenient for deleting one character
        // Removes the char at the specified position in the sequence, which is then shortened by one char
        // Throws StringIndexOutOfBoundsException if index is negative, or greater than or equal to length()
        //
        // reverse() - public StringBuilder reverse()
        // Reverses the characters in the sequence and returns a reference to the StringBuilder
        // If there are any surrogate pairs included in the sequence, these are treated as single characters for the reverse operation
        //
        // toString() - public String toString()
        // Converts a StringBuilder into a String
        // Allocates and initializes a new String object to contain the character sequence currently represented by the StringBuilder object
        // Note: changes to this sequence do not affect the contents of the String

        // Creating a StringBuilder object - with two references
        StringBuilder sb1 = new StringBuilder("Who ");
        sb1.append("Let ");
        sb1.append("The Dogs ");
        StringBuilder sb2 = sb1.append("Out");
        System.out.println(sb1);
        System.out.println(sb2); // points to sb StringBuilder objects: same output

        // Creating a StringBuilder object
        StringBuilder sbX = new StringBuilder(); // sbX will point to a StringBuilder that contains an empty sequence of characters
        System.out.println(sbX); // nothing to print
        StringBuilder sbY = new StringBuilder(10); // not a value for the StringBuilder to hold, but a capacity
        System.out.println(sbY);

        // append() - adding a parameter to the StringBuilder
        StringBuilder sb = new StringBuilder().append(333).append('x').append(2);
        sb.append("?").append(true);
        System.out.println(sb); // 333x2?true

        // insert() - add characters to StringBuilder at requested index
        System.out.println("sb1 currently is: " + sb1);
        sb1.insert(3, "?"); // adding a ? at index 3 - note that from now on, all following elements are shifted 1
        System.out.println("sb1 now is: " + sb1);
        sb1.insert(21, "?");
        // sb1.insert(25, "?"); // will cause StringIndexOutOfBoundsException
        System.out.println("sb1 now is: " + sb1);
        System.out.println();

        // insert() with CharSequence
        // in below example, 22 is the insert position of the CharSequence cSeq
        // And cSeq has to be insert starting from its element 0 to its ending element 7, which covers the whole char
        System.out.println("sb1 currently is: " + sb1);
        CharSequence cSeq =" Today?";
        sb1.insert(22, cSeq,0,7);
        System.out.println("sb1 now is: " + sb1);
        System.out.println();

        // delete() & deleteCharAt() - deleting a sequence of chars and a single char, respectively
        System.out.println("sb1 currently is: " + sb1);
        System.out.println("sb1 after deleting character at index 0 up and inclusive 5: " + sb1.delete(0,5));
        System.out.println("sb1 after deleting character at index 10: " + sb1.deleteCharAt(16));
        // System.out.println("sb1 after deleting character at index 25: " + sb1.deleteCharAt(25)); // throws exception as this element does not exist
        System.out.println();

        // reverse() - reversing the characters in sequence
        System.out.println("sb1 currently is: " + sb1);
        System.out.println("sb1 after reverse is: " + sb1.reverse());
        System.out.println();

        // toString() - converting a StringBuilder object to a String
        System.out.println("sb1 StringBuilder currently is: " + sb1);
        String s = sb1.toString();
        System.out.println("sb1 now converted to String s is: " + sb1);

        // StringBuilder Equality
        System.out.println("Testing StringBuilder equality");
        StringBuilder sbOne = new StringBuilder();
        StringBuilder sbTwo = new StringBuilder();
        StringBuilder sbThree = sbOne.append("?");
        System.out.println(sbOne == sbTwo); // false - separate StringBuilder objects
        System.out.println(sbOne == sbThree); // true - pointing to the same StringBuilder object
        System.out.println();

        // String Equality (
        // Note: never use == to compare String object equality - just for testing purposes
        // String implements an equals() methods that compares String's on its contents, instead of String itself
        // Which is what == does: determining whether the references points to the same object
        System.out.println("Testing String equality");
        String x = "Hi there";
        String y = "Hi there";
        System.out.println(x == y); // true - as Strings literals are pooled - here only one literal got created in memory, both x and y point to the same memory

        String z2 = new String("Hi There");
        System.out.println(x == z2); // false - by using new for z2, it's forced to be created as a new object, not sharing a pooled value

        String z = " Hi there".trim(); // note: when removing the space in front of Hi, trim will not be executed.. and z be considered equal to x!
        System.out.println(x == z); // false - not the same String literal (z is computed at runtime due to the trim, creating a new String object)
        System.out.println(x.equals(z)); // true - String's implemented equals() method checks the values inside a String, not the String itself
        System.out.println();


        // *********************
        // Dates and Times
        // *********************
        // In Java 8 working with dates and times got revamped
        // The new Date-Time API is aimed at being clear, fluent, immutable (previously it was not thread-safe) and extensible
        // Working with date- and time classes requires import of java.time.*
        // Java.time consists of 4 subpackages:
        // 1. java.time.chrono - representing calendar systems other than the default ISO-8601
        // 2. java.time.format - classes for formatting and parsing dates and times
        // 3. java.time.temporal - extended API for frameworks and library writers
        // 4. java.time.zone - classes that support (offsets from) time zones and time zone rules
        //
        // Java.time is based on the International Organization for Standardization (ISO-8601) calendar system
        // This calendar is based on the Gregorian calendar system
        // This system is used globally as the de facto standard for representing date and time
        // However, commonly used global calendars are also supported, using the java.time.chrono package
        // It's also possible to create and own calendar system
        //
        // Three ways of data/time info (without timezone):
        // 1. LocalDate - contains date only, no timezone
        // 2. LocalTime - contains time only, no timezone
        // 3. LocalDateTime - contains both data and time, no timezone
        //
        // Oracle recommends avoiding time zones, unless really needed
        // If needed to communicate across time zones, use ZonedDateTime
        //
        // The Date-Time API offers a rich set of methods within a rich set of classes
        // Method names are made consistent between classes where possible
        // Many classes offer a now method, capturing the date or time of the current moment
        // From methods  allow conversion from one class to another
        // Most classes in the API are immutable, hence no set methods are included
        //
        // Commonly used prefixes: of, from, parse, format, get, is, with, plus, minus, to, at
        //
        // With the methods LocalDate.of, LocalTime.of, LocalDateTime.of, one can manually create dates, times and combinations
        // Be aware that these date and time classes have private constructors to force using their static methods
        // The following will not compile: LocalDate myDate = new LocalDate();
        // It's not possible to construct a date or time object directly
        //
        // A DateTimeException is thrown when an invalid date or time value is passed
        //
        // Dates and times can be manipulated by adding and subtracting
        // As date and time classes are immutable, the results needs to be assigned to a reference variable, to prevent loss
        //
        // It's common for date and time methods to be chained
        //
        // LocalDate
        //
        //
        // LocalTime
        //
        //
        // LocalDateTime
        //
        //
        // Period
        //
        //


        // Date and time objects - using static method .now() to give the current date and time
        // The output depends on what date/time is ran and living location
        // Note: Java uses T to separate date and time when converting LocalDateTime to a String
        System.out.println("Current local date: " + LocalDate.now());
        System.out.println("Current local time: " + LocalTime.now());
        System.out.println("Current local date & time: " + LocalDateTime.now());
        System.out.println();

        // Manually creating a date without time
        LocalDate myLocalDate1 = LocalDate.of(2021, Month.AUGUST, 19); // using a Month constant (ENUM)
        LocalDate myLocalDate2 = LocalDate.of(2021, 8, 19); // using an int number to indicate the month
        System.out.println("myLocalDate1: " + myLocalDate1);
        System.out.println("myLocalDate2: " + myLocalDate2);
        System.out.println();

        // Manually creating a time
        LocalTime myLocalTime1 = LocalTime.of(11,58); // hours, minutes
        LocalTime myLocalTime2 = LocalTime.of(11,58, 30); // hours, minutes, seconds
        LocalTime myLocalTime3 = LocalTime.of(11,58, 30, 666); // hours, minutes, seconds, nanoseconds
        System.out.println("myLocalTime1: " + myLocalTime1);
        System.out.println("myLocalTime2: " + myLocalTime2);
        System.out.println("myLocalTime3: " + myLocalTime3);
        System.out.println();

        // Combining dates and times
        // Note that LocalDateTime has a load of method signatures; these are just a few combinations of them
        LocalDateTime myLocalDateTime1 = LocalDateTime.of(2021, Month.AUGUST, 19, 12, 44, 30, 200);
        LocalDateTime myLocalDateTime2 = LocalDateTime.of(myLocalDate1, myLocalTime1); // creating LocalDateTime by use of separate Date and Time objects
        // LocalDateTime myLocalDateTime3 = LocalDateTime.of(2021, Month.AUGUST, 40, 12, 44); // Will throw DateTimeException, there are no 40 days in an (earthly..) month
        // LocalDateTime myLocalDateTime4 = new LocalDateTime(); // does not compile: not allowed to construct a date or time object directly
        System.out.println("myLocalDateTime1: " + myLocalDateTime1);
        System.out.println("myLocalDateTime2: " + myLocalDateTime2);
        System.out.println();

        // Manipulating dates and time
        // Adding to a date
        LocalDate myCurrentDate = LocalDate.of(2021, Month.AUGUST, 19);
        System.out.println("Current date is: " + myCurrentDate);
        myCurrentDate = myCurrentDate.plusDays(2); // adding 2 days
        System.out.println("Current date is, after adding 2 days: " + myCurrentDate);
        myCurrentDate = myCurrentDate.plusMonths(1); // adding 1 month
        System.out.println("Current date is, after adding 1 month: " + myCurrentDate);
        myCurrentDate = myCurrentDate.plusMonths(4); // adding 4 months
        System.out.println("Current date is, after adding 4 months: " + myCurrentDate); // note it sticks to the same day, adding 4 full months
        myCurrentDate = myCurrentDate.plusDays(10); // adding 10 days
        System.out.println("Current date is, after adding 10 days: " + myCurrentDate); // note adding 11 days would result jumping to the next month
        myCurrentDate = myCurrentDate.plusMonths(1); // adding 1 month1
        System.out.println("Current date is, after adding 1 month: " + myCurrentDate); // note Java knows feb in 202 ends with 28 days
        System.out.println();

        // Subtracting from a date and time
        LocalTime myCurrentTime = LocalTime.of(13,18, 30);
        LocalDateTime myCurrentDateTime = LocalDateTime.of(myCurrentDate, myCurrentTime); // note expecting date first, then time
        System.out.println("Current date/time is: " + myCurrentDateTime); // note it adds a full month, up to the last day possible of Feb (in that year)
        myCurrentDateTime = myCurrentDateTime.minusHours(10); // subtracting 10 hours
        System.out.println("Current date/time, after subtracting 10 hours: " + myCurrentDateTime);
        // same goes for subtracting minutes, seconds, nanoseconds
        System.out.println();

        // Chaining methods
        System.out.println("Current date/time is: " + myCurrentDateTime);
        myCurrentDateTime = LocalDateTime.of(myCurrentDate, myCurrentTime).minusDays(28).minusHours(10).minusSeconds(30);
        System.out.println("Current date/time is after subtracting using chained methods: " + myCurrentDateTime);
        System.out.println();

        // Checking if a date is before another date
        myLocalDateTime1 = myLocalDateTime1.of(2021, Month.JANUARY, 1, 23, 59, 59);
        //myLocalDateTime1 = myLocalDateTime1.of(2021, Month.AUGUST, 22, 14, 16, 30);
        myLocalDateTime2 = myLocalDateTime2.of(2021, Month.AUGUST, 22, 14, 16, 30);
        //myLocalDateTime2 = myLocalDateTime2.of(2021, Month.JANUARY, 1, 23, 59, 59);
        System.out.println("myLocalDateTime1: " + myLocalDateTime1);
        System.out.println("myLocalDateTime2: " + myLocalDateTime2);
        System.out.println("myLocalDateTime1 is before myLocalDateTime2?: " + myLocalDateTime1.isBefore(myLocalDateTime2));
        System.out.println();

        // Using Period to cary out a recurring action between a start and end date
        LocalDate start = LocalDate.of(2021, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2021, Month.APRIL, 1);
        Period period = Period.ofMonths(1); // creates a period of 1 month
        // Period period = Period.of(3, 2, 1); // periods can also be set up as combination of years, months, days
        while (start.isBefore(end)) {
            System.out.println("some action");
            start = start.plus(period); // adding period to start date, which will eventually lead to ending the loop
        }
        System.out.println();

        // Note: it's not possible to chain methods when creating a Period
        // In the following example, only the last method is used
        // This is because Period.of.XXX methods are static methods
        Period nogoodperiod = Period.ofYears(1).ofWeeks(1);
        System.out.println("nogoodperiod: " + nogoodperiod); // results in P7D, meaning a period of 7 days, thus neglecting the year
        System.out.println();

        // Adding a period to a LocalDateTime object
        // Note: adding a period to a LocalTime only object would cause an UnsupportedTemporalTypeException
        System.out.println("myCurrentDateTime: " + myCurrentDateTime);
        System.out.println("period: " + period); // P1M = 1 month
        myCurrentDateTime = myCurrentDateTime.plus(period);
        System.out.println("myCurrentDateTime, after adding period: " + myCurrentDateTime);
        System.out.println();

        // Formatting Dates and Times
        // First, with standard methods
        System.out.println("myCurrentDateTime: " + myCurrentDateTime);
        System.out.println("day of week: " + myCurrentDateTime.getDayOfWeek());
        System.out.println("day of month: " + myCurrentDateTime.getDayOfMonth());
        System.out.println("day of year: " + myCurrentDateTime.getDayOfYear());
        System.out.println("month: " + myCurrentDateTime.getMonth());
        System.out.println("hour: " + myCurrentDateTime.getHour());
        System.out.println("year: " + myCurrentDateTime.getYear());
        System.out.println();

        // Using DateTimeFormatter (in java.time.format package)
        myCurrentDateTime = LocalDateTime.now();
        System.out.println("myCurrentDateTime: " + myCurrentDateTime); // getting the current date and time
        System.out.println("date: " + myCurrentDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE)); // showing date only
        System.out.println("time: " + myCurrentDateTime.format(DateTimeFormatter.ISO_LOCAL_TIME)); // showing time only
        System.out.println("date time: " + myCurrentDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); // showing date time
        System.out.println();

        // Using DateTimeFormatter, in a predefined SHORT and MEDIUM style format
        System.out.println("Using DateTimeFormatter, in a predefined SHORT and MEDIUM style format");
        DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        LocalDate date = LocalDate.of(2021, Month.AUGUST, 20);
        LocalTime time = LocalTime.of(11, 43, 0);
        LocalDateTime datetime = LocalDateTime.of(date,time);

        DateTimeFormatter shortForm = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter mediumForm = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        System.out.println(shortForm.format(datetime));
        System.out.println(mediumForm.format(datetime));
        System.out.println();

        // Using DateTimeFormatter, with a format pattern
        System.out.println("Using DateTimeFormatter, with a format pattern");
        System.out.println("myCurrentDateTime: " + myCurrentDateTime); // getting the current date and time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); // creating a pattern to format
        System.out.println("date time again, applying a format pattern: " + dtf.format(myCurrentDateTime)); // dropping nanoseconds
        dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm", Locale.ENGLISH); // creating another pattern to format - setting Locale to English
        System.out.println("date time again, applying another format pattern: " + dtf.format(myCurrentDateTime));
        System.out.println();

        // Another short example
        System.out.println("Another short example");
        dtf = DateTimeFormatter.ofPattern("hh:mm");
        System.out.println(dtf.format(datetime)); // will only express time as the pattern does not include date
        // System.out.println(dtf.format(date)); // will cause an exception as the pattern does not include date and date is all that's asked to be formatted here
        System.out.println(dtf.format(time));
        System.out.println();

        // Converting a String to a date or time, using .parse
        System.out.println("Converting a String to a date or time, using .parse");
        dtf = DateTimeFormatter.ofPattern("MM dd yyyy");
        date = LocalDate.parse("08 20 2021", dtf);
        time = LocalTime.parse("11:22");
        System.out.println(date);
        System.out.println(time);
        System.out.println();

    }
}