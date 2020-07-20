def paintItRed():
    # paint it red
    return


def paintItGreen():
    # paint it green
    return


def paintItBlue():
    # paint it blue
    return


def paintIt():
    # paint it
    return


def paintSelection(i):
    switcher = {
        'red': paintItRed,
        'green': paintItGreen,
        'blue': paintItBlue
    }
    func = switcher.get(i, paintIt)
    return func()


paintSelection('red')
paintSelection('blue')
paintSelection('green')
paintSelection('black')
