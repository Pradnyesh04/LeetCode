class Solution:
    def myAtoi(self, s):
        s = s.strip()

        if s == "":
            return 0

        sign = 1

        if s[0] == '-':
            sign = -1
            s = s[1:]
        elif s[0] == '+':
            s = s[1:]

        num = 0

        for x in s:
            if x < '0' or x > '9':
                break

            num = num * 10 + (ord(x) - ord('0'))

        num = num * sign

        if num > 2147483647:
            return 2147483647

        if num < -2147483648:
            return -2147483648

        return num