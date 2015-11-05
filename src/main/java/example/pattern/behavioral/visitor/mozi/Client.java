package example.pattern.behavioral.visitor.mozi;

import java.util.ArrayList;
import java.util.List;

interface Horse {
  public void accept(Visitor v);
}

class BlackHorse implements Horse {
  @Override
  public void accept(Visitor v) {
    v.ride(this);
  }
}

class WhiteHorse implements Horse {
  @Override
  public void accept(Visitor v) {
    v.ride(this);
  }
}

interface Visitor {
  void ride(WhiteHorse wh);

  void ride(BlackHorse bh);
}

//具体实现方法在访问者
class Mozi implements Visitor {
  public void ride(WhiteHorse wh) {
    //detail code
    System.out.println("墨子骑白马");
  }

  public void ride(BlackHorse bh) {
    //detail code
    System.out.println("墨子骑黑马");
  }
}

class ObjectStructure {
  private List<Horse> horses = new ArrayList<Horse>();

  public void action(Visitor visitor) {
    for (Horse horse : horses) {
      horse.accept(visitor);
    }
  }

  public void add(Horse horse) {
    horses.add(horse);
  }
}

public class Client {
  public static void main(String[] args) {
    /*//行不通
    Horse wh = new WhiteHorse();
    Mozi mozi = new Mozi();
    mozi.ride(wh);*/

    Mozi mozi = new Mozi();
    Horse wh = new WhiteHorse();
    wh.accept(mozi);

    ObjectStructure structure = new ObjectStructure();
    structure.add(new WhiteHorse());
    structure.add(new BlackHorse());
    structure.action(mozi);
  }

}
