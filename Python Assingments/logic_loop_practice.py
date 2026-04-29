def notCentered():
    stars = "*****"
    for i in range(len(stars)):
        print(stars[:i])
    for i in range(len(stars), 0, -1):
        print(stars[:i])
def diamond(size):
    for i in range(1, size + 1):
        print(" " * (size - i) + "* " * i)
    for i in range(size - 1, 0, -1):
        print(" " * (size - i) + "* " * i)
def main():
    print("This is triangle:")
    notCentered()
    print("This is a diamond:")
    diamond(5)
main()