package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    private List<Entry> list = new ArrayList<>();

    public CustomTree() {
        root = new Entry<>("0");
        list.add(root);
    }

    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String s) {
        Entry newEntry = new Entry(s);
        boolean availableAdd = false;
        for (Entry entry : list) {
            if (entry.isAvailableToAddChildren()) {
                if (entry.availableToAddLeftChildren) {
                    entry.leftChild = newEntry;
                    newEntry.parent = entry;
                    entry.availableToAddLeftChildren = false;
                    availableAdd = true;
                    break;
                } else {
                    entry.rightChild = newEntry;
                    newEntry.parent = entry;
                    entry.availableToAddRightChildren = false;
                    availableAdd = true;
                    break;
                }
            }
        }
        if (!availableAdd){
            for (Entry entry : list) {
                if (entry.rightChild == null){
                    entry.availableToAddRightChildren = true;
                }
                if (entry.leftChild == null){
                    entry.availableToAddLeftChildren = true;

                }
            }
            for (Entry entry : list) {
                if (entry.isAvailableToAddChildren()) {
                    if (entry.availableToAddLeftChildren) {
                        entry.leftChild = newEntry;
                        newEntry.parent = entry;
                        entry.availableToAddLeftChildren = false;
                        break;
                    } else {
                        entry.rightChild = newEntry;
                        newEntry.parent = entry;
                        entry.availableToAddRightChildren = false;
                        break;
                    }
                }
            }
        }
        list.add(newEntry);
        return true;
    }

    @Override
    public int size() {
        return list.size() - 1;
    }

    public String getParent(String s) {
        for (Entry entry : list) {
            if (entry.elementName.equals(s)) return entry.parent.elementName;
        }
        return null;
    }

    public boolean remove(Object o) {
        if (!(o instanceof String)) throw new UnsupportedOperationException();

        Iterator<Entry> iterator = list.iterator();
        String str = (String) o;
        Stack<Entry> stack = new Stack<>();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.elementName.equals(str)) {
                if(entry.parent.leftChild == entry){
                    entry.parent.leftChild = null;
                } else {
                    entry.parent.rightChild = null;
                }
                stack.push(entry.leftChild);
                stack.push(entry.rightChild);
                iterator.remove();
            }
        }
        while (!stack.empty()){
            Entry entry = stack.pop();
            if (entry.leftChild != null) stack.push(entry.leftChild);
            if (entry.rightChild != null) stack.push(entry.rightChild);
            list.remove(entry);
        }


        return false;
    }


    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

}
/*Необходимо реализовать метод remove(Object o), который будет удалять элемент дерева имя которого было полученного в качестве параметра.

Если переданный объект не является строкой, метод должен бросить UnsupportedOperationException.

Если в дереве присутствует несколько элементов с переданным именем - можешь удалить только первый найденный.

Не забывай сверять поведение своего дерева с картинкой:


Что будет если удалить из дерева элементы "3", "4", "5" и "6", а затем попытаемся добавить новый елемент?

В таком случае элементы "1" и "2" должны восстановить возможность иметь потомков (возможно придется внести изменения в метод add()).

Требования:
1. После удаления последнего добавленного элемента из дерева с помощью метода remove, метод size должен возвращать N-1.
2. После удаления второго элемента добавленного в дерево, метод size должен возвращать N/2 + 1 (для случаев где N > 2 и является степенью двойки), N - размер дерева до удаления.
3. Если переданный объект не является строкой, метод remove() должен бросить UnsupportedOperationException.
4. Если ни один элемент не способен иметь потомков, необходимо восстановить такую возможность.*/