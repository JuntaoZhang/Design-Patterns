package example.pattern.behavioral.visitor.BeeAndFlowers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


// The Flower hierarchy cannot be changed:
//元素角色
interface Flower {
  void accept(Visitor v);
}

class Gladiolus implements Flower {
  public void accept(Visitor v) {
    v.visit(this);
  }
}

class Ranunculus implements Flower {
  public void accept(Visitor v) {
    v.visit(this);
  }
}

class Chrysanthemum implements Flower {
  public void accept(Visitor v) {
    v.visit(this);
  }
}

interface Visitor {
  void visit(Gladiolus g);

  void visit(Ranunculus r);

  void visit(Chrysanthemum c);
}

// Add the ability to produce a string: 
//实现的具体访问者角色
class StringVal implements Visitor {
  String s;

  public String toString() {
    return s;
  }

  public void visit(Gladiolus g) {
    s = "Gladiolus";
  }

  public void visit(Ranunculus r) {
    s = "Runuculus";
  }

  public void visit(Chrysanthemum c) {
    s = "Chrysanthemum";
  }
}

// Add the ability to do "Bee" activities: 
//另一个具体访问者角色
class Bee implements Visitor {
  public void visit(Gladiolus g) {
    System.out.println("Bee and Gladiolus");
  }

  public void visit(Ranunculus r) {
    System.out.println("Bee and Runuculus");
  }

  public void visit(Chrysanthemum c) {
    System.out.println("Bee and Chrysanthemum");
  }
}

//这是一个对象生成器 
//这不是一个完整的对象结构，这里仅仅是模拟对象结构中的元素

class FlowerGenerator {
  private static Random rand = new Random();

  public static Flower newFlower() {
    switch (rand.nextInt(3)) {
      default:
      case 0:
        return new Gladiolus();
      case 1:
        return new Ranunculus();
      case 2:
        return new Chrysanthemum();
    }
  }
}

public class Client {
  List<Flower> flowers = new ArrayList<Flower>();

  public Client() {
    for (int i = 0; i < 4; i++)
      flowers.add(FlowerGenerator.newFlower());
  }

  public void test() {
    // It’s almost as if I had a function to 
    // produce a Flower string representation: 
    //这个地方你可以修改以便使用另外一个具体访问者角色
    Visitor visitor = new StringVal();
    Iterator it = flowers.iterator();
    while (it.hasNext()) {
      ((Flower) it.next()).accept(visitor);
      System.out.println(visitor);
    }

    System.out.println("================");

    visitor = new Bee();
    it = flowers.iterator();
    while (it.hasNext()) {
      ((Flower) it.next()).accept(visitor);
    }

  }

  public static void main(String[] args) {
    new Client().test();
  }
}
