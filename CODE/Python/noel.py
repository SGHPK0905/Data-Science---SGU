import os
import time
import random

def clear_console():
    os.system('cls' if os.name == 'nt' else 'clear')

def print_tree(lights_on):
    tree = [
        "         *         ",
        "        ***        ",
        "       *****       ",
        "      *******      ",
        "     *********     ",
        "    ***********    ",
        "   *************   ",
        "         |||       "
    ]

    colors = {
        "r": "\033[31m",  # Red
        "g": "\033[32m",  # Green
        "y": "\033[33m",  # Yellow
        "b": "\033[34m",  # Blue
        "p": "\033[35m",  # Purple
        "c": "\033[36m",  # Cyan
        "reset": "\033[0m"
    }

    # tạo danh sách màu chớp theo nhịp
    color_keys = list(colors.keys())[:-1]
    color = colors[random.choice(color_keys)]
    off_color = "\033[90m"  # màu xám mờ cho đèn tắt

    for i, line in enumerate(tree):
        line_chars = list(line)
        for j, ch in enumerate(line_chars):
            if ch == '*':
                # nếu lights_on là True => đèn sáng, False => tắt
                if (i + j + lights_on) % 2 == 0:
                    line_chars[j] = color + '*' + colors["reset"]
                else:
                    line_chars[j] = off_color + '.' + colors["reset"]
        print("".join(line_chars))

def show_lyrics_slowly(lyrics, speed=0.04):
    for line in lyrics:
        for char in line:
            print(char, end='', flush=True)
            time.sleep(speed)
        print()
        time.sleep(0.3)

def main():
    lyrics = [
        "A face on a lover",
        "With a fire in his heart",
        "A man undercover",
        "But you tore me apart",
        "Oh oh",
        "Now I've found a real love"
    ]

    lights_on = 0
    while True:
        clear_console()
        print_tree(lights_on)
        print()
        show_lyrics_slowly(lyrics)
        time.sleep(0.5)  # tốc độ nhấp nháy
        lights_on = 1 - lights_on  # đổi trạng thái sáng/tối

try:
    main()
except KeyboardInterrupt:
    clear_console()
    print("✨ Merry Christmas, see you again! 🎄")
