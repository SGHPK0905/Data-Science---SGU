import time
import itertools
import random
import os

# ANSI colors
COLORS = [
    "\033[31m",  # đỏ
    "\033[32m",  # xanh lá
    "\033[33m",  # vàng
    "\033[34m",  # xanh dương
    "\033[35m",  # tím
    "\033[36m",  # cyan
]

RESET = "\033[0m"
BRIGHT = "\033[1m"

# ASCII tree
TREE = [
    "         *         ",
    "        ***        ",
    "       *****       ",
    "      *******      ",
    "     *********     ",
    "    ***********    ",
    "   *************   ",
    "        ###        ",
    "        ###        "
]

LYRICS = [
    "We wish you a Merry Christmas",
    "We wish you a Merry Christmas",
    "We wish you a Merry Christmas",
    "And a Happy New Year!"
]

MESSAGE = "yêu bé Ý Nhi, giáng sinh vui vẻ"

def colorize_tree():
    colored = []
    for line in TREE:
        new_line = ""
        for ch in line:
            if ch == "*":
                new_line += random.choice(COLORS) + "*" + RESET
            else:
                new_line += ch
        colored.append(new_line)
    return "\n".join(colored)

def gradient_text(text, shift):
    result = ""
    for i, ch in enumerate(text):
        color = COLORS[(i + shift) % len(COLORS)]
        result += color + BRIGHT + ch + RESET
    return result

def main():
    lyric_cycle = itertools.cycle(LYRICS)
    shift = 0
    blink = True

    while True:
        os.system("cls" if os.name == "nt" else "clear")

        # Tree blink
        print(colorize_tree())

        # Lyrics
        lyric = next(lyric_cycle)
        print("\n♪", lyric, "♪")

        # Gradient + blinking message
        if blink:
            print("\n" + gradient_text(MESSAGE, shift))
        else:
            print("\n")  # blink off

        # update effect
        shift += 1
        blink = not blink

        time.sleep(0.35)

try:
    main()
except KeyboardInterrupt:
    print("\nExited.")
