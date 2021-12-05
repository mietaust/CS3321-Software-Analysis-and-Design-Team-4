package Backend;

enum Color {
  RED(3),
  ORANGE(3),
  PURPLE(3),
  LIGHTBLUE(3),
  YELLOW(3),
  GREEN(3),
  DARKBLUE(2),
  BROWN(2);

  int totalGroupNumber;

  Color(int totalGroupNumber) {
    this.totalGroupNumber = totalGroupNumber;
  }
}
