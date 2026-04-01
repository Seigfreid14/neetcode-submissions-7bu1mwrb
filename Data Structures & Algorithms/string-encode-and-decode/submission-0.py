class Solution:

    def encode(self, strs: list[str]) -> str:
        res = ""
        for s in strs:
            res += str(len(s)) + "#" + s
        return res

    def decode(self, s: str) -> list[str]:
        res = []
        i = 0

        while i < len(s):
            # find the '#'
            j = i
            while s[j] != '#':
                j += 1

            # get length
            length = int(s[i:j])

            # move pointer after '#'
            i = j + 1

            # get the string
            word = s[i:i + length]
            res.append(word)

            # move pointer to next part
            i = i + length

        return res