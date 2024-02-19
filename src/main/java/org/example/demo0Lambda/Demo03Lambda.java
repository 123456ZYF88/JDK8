package org.example.demo0Lambda;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author zhangyifan
 * @version 8.0
 * @description: 有参有返回值的Lambda
 * @date 2021/12/28 19:13
 */
public class Demo03Lambda {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("刘德华", 58, 174));
        persons.add(new Person("张学友", 58, 176));
        persons.add(new Person("刘德华", 54, 171));
        persons.add(new Person("黎明", 53, 178));

     /*   Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        });*/

/*        Collections.sort(persons,(Person o1,Person o2) ->{
            return o2.getAge()-o1.getAge();
        });*/
        //升级
        Collections.sort(persons,(p1,p2) -> p1.getAge() - p2.getAge());

    /*    for (Person proc:persons){
            System.out.println(proc);
        }*/
        //Lambda 升级
        persons.forEach( t -> System.out.println(t));
    }

}
