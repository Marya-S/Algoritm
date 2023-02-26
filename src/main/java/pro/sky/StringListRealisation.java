package pro.sky;

import exception.IndexOfBoundException;
import exception.ItemNotFoundException;

import java.util.Arrays;

public class StringListRealisation implements StringList {
    private int size;
    private String[] list;

    public StringListRealisation(int size) {
        this.size = size;
        list = new String[size];
    }

    public StringListRealisation() {
        this.size = 0;
        list = new String[size];
    }


    @Override
    public String add(String item) {
        if(item != null){
        if (list.length == size) {
            size++;
            String[] newList = new String[size];
            for (int i = 0; i < list.length; i++) {
                newList[i] = list[i];
            }
            newList[size - 1] = item;
            list = newList;
        }
        return item;
    }
        IndexOfBoundException exception = new IndexOfBoundException("Массив не может быть 0");
        return null;
    }

    @Override
    public String add(int index, String item) {
        if (index > list.length) {
            IndexOfBoundException exception = new IndexOfBoundException("Длинна массива меньше, чем индекс " + index);
            System.out.println(exception.getMessage());
            return null;
        } else {
            size++;
            String[] newList = new String[size];
            for (int i = 0; i <= list.length; i++) {
                if (i < index) {
                    newList[i] = list[i];
                } else if (i == index) {
                    newList[index] = item;
                } else {
                    newList[i] = list[i - 1];
                }
            }

            list = newList;
            return item;
        }
    }

    @Override
    public String set(int index, String item) {
        if (index > list.length || index > countItem(list)) {
            IndexOfBoundException exception = new IndexOfBoundException("Длинна массива меньше, чем индекс " + index);
            System.out.println(exception.getMessage());
            return null;
        } else {
            list[index] = item;
            return item;
        }
    }

    @Override
    public String remove(String item) {
        boolean delete = false;
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(item)) {
                delete = true;
            }
        }
        if (delete) {
            int j = 0;
            size--;
            String[] newList = new String[size];
            while (newList.length > j) {
                for (int i = 0; i < list.length; i++) {
                    if (!list[i].equals(item)) {
                        newList[j] = list[i];
                        j++;
                    }
                }
            }
            list = newList;
            return item;
        } else {
            ItemNotFoundException exception = new ItemNotFoundException("Элемент не найден");
            System.out.println(exception.getMessage());
            return null;
        }

    }

    @Override
    public String remove(int index) {
        if (list.length > index) {
            String item = list[index];
            int j = 0;
            size--;
            String[] newList = new String[size];
            while (newList.length > j) {
                for (int i = 0; i < list.length; i++) {
                    if (i != index) {
                        newList[j] = list[i];
                        j++;
                    }
                }
            }
            list = newList;
            return item;
        } else {
            ItemNotFoundException exception = new ItemNotFoundException("Элемент не найден");
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= countItem(list)) {
            IndexOfBoundException exception = new IndexOfBoundException("Длинна массива меньше, чем индекс");
            System.out.println(exception.getMessage());
            return null;
        } else {
            return list[index];
        }
    }

    @Override
    public boolean equals(StringList otherList) {
        boolean result = true;
        if (otherList.isEmpty()) {
            ItemNotFoundException exception = new ItemNotFoundException("Передан пустой массив");
            System.out.println(exception.getMessage());
            return false;
        } else {
            if (otherList.size() == list.length) {
                for (int i = 0; i < list.length; i++) {
                    if (!otherList.get(i).equals(list[i])) {
                        result = false;
                    }
                }
            } else {
                result = false;
            }
        }
        return result;
    }

    @Override
    public int size() {
        return countItem(list);
    }

    @Override
    public boolean isEmpty() {
        if (countItem(list) > 0) {
            return false;
        }
        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(list, null);
    }

    @Override
    public String[] toArray() {
        String[] newList = new String[size];
        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }
        return newList;
    }

    private Integer countItem(String[] arr) {
        int count = 0;
        for (String item : arr
        ) {
            if (item != null) {
                count++;
            }
        }
        return count;
    }

    public int getSize() {
        return size;
    }
}
