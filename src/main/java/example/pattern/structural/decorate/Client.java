package example.pattern.structural.decorate;

interface Component {
  void operation();
}

class ConcreteComponent implements Component {
  public void operation() {
    //detail code
    System.out.println("operation()");
  }
}

class Decorator implements Component {
  private Component component;

  public Decorator(Component component) {
    this.component = component;
  }

  public void operation() {
    component.operation();
  }
}

class ConcreteDecorator extends Decorator {
  public ConcreteDecorator(Component component) {
    super(component);
  }

  public void operation() {
    super.operation();
    this.otherOperation();
  }

  public void otherOperation() {
    //detail code
    System.out.println("otherOperation()");
  }
}

public class Client {
  public static void main(String[] args) {
    Component component = new ConcreteComponent();
    Component decorator = new ConcreteDecorator(component);
    //客户端不变, 但已增加了责任
    decorator.operation();
  }
}
