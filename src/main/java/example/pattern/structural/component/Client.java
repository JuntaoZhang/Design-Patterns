package example.pattern.structural.component;

import java.util.Enumeration;
import java.util.Vector;

abstract class Component {
  private String flag;

  public abstract void sampleOperation();

  public Component(String flag) {
    this.flag = flag;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Component)) return false;
    Component component = (Component) o;
    return flag.equals(component.flag);
  }

  @Override
  public int hashCode() {
    return flag.hashCode();
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }
}

class Composite extends Component {
  private Vector<Component> componentVector = new Vector<Component>();

  public Composite(String flag) {
    super(flag);
  }

  public void sampleOperation() {
    Enumeration<Component> enumeration = components();
    while (enumeration.hasMoreElements()) {
      enumeration.nextElement().sampleOperation();
    }
  }

  public void add(Component component) {
    componentVector.add(component);
  }

  public void remove(Component component) {
    componentVector.remove(component);
  }

  public Enumeration<Component> components() {
    return componentVector.elements();
  }
}

class Leaf extends Component {
  public Leaf(String flag) {
    super(flag);
  }

  public void sampleOperation() {
    System.out.println("叶子[" + super.getFlag() + "]:sampleOperation()");
  }

}

public class Client {
  public static void main(String[] args) {
    Composite root = new Composite("root");
    //构造次枝
    Composite composite = new Composite("composite");
    root.add(composite);
    //构造叶子
    composite.add(new Leaf("leaf1"));
    composite.add(new Leaf("leaf2"));
    composite.remove(new Leaf("leaf1"));

    root.sampleOperation();
  }
}
