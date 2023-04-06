/*
 * Урок 5. Хранение и обработка данных ч2: множество коллекций Map
 */
//////////////////////////////////////////////////////////////////////////////////

// HashMap

/*
 * Map – это множество коллекций, работающих с данными
 * по принципу <Ключ / Значение>.
 * 
 * 
 * Ключевые особенности:
 * 
 * ● допускаются только уникальные ключи, значения
 * могут повторяться;
 * ● помните про null значения*;
 * ● ускоренная обработка данных;
 * ● порядок добавления не запоминается.
 * 
 * 
 * В HashMap элементы располагаются как угодно и могут
 * менять свое положение.
 */

import java.util.*;

public class program {
    public static void main(String[] args) {
        Map<Integer, String> db = new HashMap<>();
        db.putIfAbsent(1, "один");
        db.put(2, "два");
        db.put(null, "!null");
        System.out.println(db); // {null=!null, 1=один, 2=два}
        System.out.println(db.get(44));
        // db.remove(null);
        System.out.println(db); // {1=один, 2=два}
        System.out.println(db.containsValue("один")); // true
        // System.out.println(db.containsValue(1)); // false
        // System.out.println(db.containsKey("один")); // false
        System.out.println(db.containsKey(1)); // true
        System.out.println(db.keySet());
        System.out.println(db.values());

    }
}

/*
ОТВЕТ:
{null=!null, 1=один, 2=два}
null
{null=!null, 1=один, 2=два}
true
true
[null, 1, 2]
[!null, один, два]
 */

//////////////////////////////////////////////////////////////////////////////////

// HashMap. Важное замечание

// таблица с 0 до 10


Map<Integer, String> db = new HashMap<>();
db.put(1, "один"); => 2809 => ОСТ102809 = 9

Map<Integer, String> db = new HashMap<>();
db.put(3, "три"); => 1990 => ОСТ101990 = 0

Map<Integer, String> db = new HashMap<>();
db.put(2, "два"); => 1236 => ОСТ101236 = 6

Map<Integer, String> db = new HashMap<>();
db.put(32, "три два"); => 9999 => ОСТ109999 = 9


//////////////////////////////////////////////////////////////////////////////////

// HashMap. Важное дополнение

// Работа с парами

import java.util.*;

public class program {
public static void main(String[] args) {
Map<Integer, String> db = new HashMap<>();
db.putIfAbsent(1, "один");
db.put(2, "два");
db.put(3, "три");
System.out.println(db);
for (var item : db.entrySet()) {
System.out.printf("[%d: %s]\n", item.getKey(), item.getValue());
}
}
}

/*
 * ОТВЕТ:
 * {1=один, 2=два, 3=три}
 * [1: один]
 * [2: два]
 * [3: три]
 */

//////////////////////////////////////////////////////////////////////////////////

// HashMap. Важное дополнение #2. Скорость

// Как ускорить работу

import java.util.*;

public class program {
public static void main(String[] args) {
Map<Integer, String> map1 = new HashMap<>();
Map<Integer, String> map2 = new HashMap<>(9);
Map<Integer, String> map3 = new HashMap<>(9, 1.0f);
}
}

//////////////////////////////////////////////////////////////////////////////////

/*
 * HashMap. Любознательным
 * 
 * ● Хэш-функции и хэш-таблицы
 * ● Прямое связывание (хэширование с цепочками)
 * ● Хэширование с открытой адресацией
 * ● Теория графов:
 * ● деревья построенные на списках
 * ● бинарные деревья
 * ● сбалансированные деревья
 * ● *алгоритм балансировки дерева
 * ● ** красно-черные деревья, деревья поиска
 */

//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////

// TreeMap

import java.util.*;

public class program {
public static void main(String[] args) {
TreeMap<Integer, String> tMap = new TreeMap<>();
tMap.put(1, "один");
System.out.println(tMap);
// {1=один}
tMap.put(6, "шесть");
System.out.println(tMap);
// {1=один, 6=шесть}
tMap.put(4, "четыре");
System.out.println(tMap);
// {1=один, 4=четыре, 6=шесть}
tMap.put(3, "три");
System.out.println(tMap);
// {1=один, 3=три, 4=четыре, 6=шесть}
tMap.put(2, "два");
System.out.println(tMap);
// {1=один, 2=два, 3=три, 4=четыре, 6=шесть}
}
}

/*
 * ОТВЕТ:
 * {1=один}
 * {1=один, 6=шесть}
 * {1=один, 4=четыре, 6=шесть}
 * {1=один, 3=три, 4=четыре, 6=шесть}
 * {1=один, 2=два, 3=три, 4=четыре, 6=шесть}
 */

//////////////////////////////////////////////////////////////////////////////////

// TreeMap

/*
 * Методы, на которые нужно обратить внимание
 * 
 * put(K,V) get(K) remove(K) descendingKeySet(V)
 * descendingMap() tailMap() headMap() lastEntry() firstEntry()
 * 
 * 
 * В основе данной коллекции лежат красно-чёрное деревья.
 * Позволяют быстрее искать, но могут возникнуть «заминки»
 * при добавлении.
 */

//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////

// LinkedHashMap

/*
 * «Старший брат» коллекции HashMap, который все помнит…
 * Помнит порядок добавления элементов ➜ более медлительный
 * 
 * Map<Integer,String> linkmap = new LinkedHashMap<>();
 * 
 */

import java.util.*;

public class program {
public static void main(String[] args) {
Map<Integer, String> linkmap = new LinkedHashMap<>();
linkmap.put(11, "один один");
linkmap.put(1, "два");
linkmap.put(2, "один");
System.out.println(linkmap); // {11=один один, 1=два, 2=один}
Map<Integer, String> map = new HashMap<>();
map.put(11, "один один");
map.put(2, "два");
map.put(1, "один");
System.out.println(map); // {1=один, 2=два, 11=один один}
}
}

/*
 * ОТВЕТ:
 * {11=один один, 1=два, 2=один}
 * {1=один, 2=два, 11=один один}
 */

//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////

// HashTable

/*
 * «Устаревший брат» коллекции HashMap,
 * который не знает про null
 */

import java.util.*;

public class program {
    public static void main(String[] args) {
        Map<Integer, String> table = new Hashtable<>();
        table.put(1, "два");
        table.put(11, "один один");
        table.put(2, "один");
        System.out.println(table); // {2=один, 1=два, 11=один один}
        // table.put(null, "один"); // java.lang.NullPointerException
    }
}

/*
 * ОТВЕТ:
 * {2=один, 1=два, 11=один один}
 */
