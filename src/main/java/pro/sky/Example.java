package pro.sky;

public class Example {
    public static void main(String[] args) {
        StringListRealisation array = new StringListRealisation();
        array.add("Яблоко");
        array.add("Абрикос");
        array.add("Клубника");
        array.add("Груша");
        array.add("Киви");
        array.add(4, "Банан");
        array.add(10, "Ананас");
        array.set(3, "Ананас");
        array.set(8, "Виноград");
        array.remove("Яблоко");
        array.remove("Картошка");
        array.remove(2);
        array.remove(10);
        System.out.println("Элемент всписке на " + array.contains("Абрикос"));
        System.out.println("Элемент всписке на " + array.contains("Крыжовник"));
        System.out.println("Элемент всписке на " + array.indexOf("Абрикос"));
        System.out.println("Элемент всписке на " + array.indexOf("Крыжовник"));
        System.out.println("Элемент всписке на " + array.lastIndexOf("Абрикос"));
        System.out.println("Элемент всписке на " + array.lastIndexOf("Крыжовник"));
        System.out.println(array.get(3));
        System.out.println(array.get(13));
        StringListRealisation secondArray = new StringListRealisation();
        String[] temp = array.toArray();
        for (int i = 0; i < array.getSize(); i++) {
            secondArray.add(temp[i]);
        }
        System.out.println(secondArray.isEmpty());
        System.out.println(array.equals(secondArray));
        array.clear();
        System.out.println(array.isEmpty());
        System.out.println(array.equals(secondArray));
    }

}

