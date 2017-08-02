package conf;

/**
 * A paper which may be submitted to a conference
 */
public class Paper implements jif.lang.JifObject
{
    private String title;
    private String paperAbstract;
    private Author[] authors;
    
    public Paper conf$Paper$(final String title, final String paperAbstract,
                             final Author[] authors) {
        this.jif$init();
        {
            this.title = title;
            this.paperAbstract = paperAbstract;
            try {
                this.authors = (new Author[authors.length]);
                for (int i = 0; i < authors.length; ++i) {
                    this.authors[i] = authors[i];
                }
            }
            catch (final NullPointerException ex) {
                this.authors = (new Author[2]);
            }
            catch (final ArrayIndexOutOfBoundsException ex) {  }
        }
        return this;
    }
    
    public String getTitle() { return this.title; }
    
    public String getAbstract() { return this.paperAbstract; }
    
    public Author[] getAuthors() {
        if (this.authors == null) { return new Author[2]; }
        return (Author[]) this.authors.clone();
    }
    
    public boolean equals(final Object o) {
        try {
            Paper other;
            try {
                other =
                  Paper.
                    jif$cast$conf_Paper(
                      jif.lang.LabelUtil.
                        singleton().
                        toLabel(
                          jif.lang.LabelUtil.singleton().bottomConf(),
                          jif.lang.LabelUtil.singleton().
                            writerPolicy(
                              jif.lang.PrincipalUtil.topPrincipal(),
                              jif.lang.PrincipalUtil.topPrincipal())),
                      o);
            }
            catch (final ClassCastException ex) { return false; }
            if (this.authors.length != other.authors.length) return false;
            for (int i = 0; i < this.authors.length; ++i) {
                try {
                    if (!this.authors[i].equals(other.authors[i])) {
                        return false;
                    }
                }
                catch (final ArrayIndexOutOfBoundsException ex) {
                    return false;
                }
            }
            return other.title.equals(this.title) &&
              other.paperAbstract.equals(this.paperAbstract);
        }
        catch (final NullPointerException ex) { return false; }
    }
    
    public boolean equals(final jif.lang.Label lbl,
                          final jif.lang.IDComparable o) {
        try {
            return this.equals((Object) o);
        }
        catch (final ClassCastException ex) { return false; }
    }
    
    public boolean equals(final jif.lang.IDComparable o) {
        return this.equals(this.jif$conf_Paper_AuthorLabel, o);
    }
    
    public int hashCode() {
        try {
            int result = 19;
            result = 31 * result + this.title.hashCode();
            result = 31 * result + this.paperAbstract.hashCode();
            for (int i = 0; i < this.authors.length; ++i) {
                try {
                    result = 31 * result + this.authors[i].hashCode();
                }
                catch (final ArrayIndexOutOfBoundsException ex) {  }
            }
            return result;
        }
        catch (final NullPointerException ex) { return 0; }
    }
    
    public String toString() {
        String s = "";
        s += "Title: " + this.title + "\n";
        s += "Abstract: " + this.paperAbstract + "\n";
        s += "Authors: ";
        String sep = "";
        try {
            for (int i = 0; i < this.authors.length; ++i) {
                s += sep + this.authors[i].toString();
                sep = ",";
            }
        }
        catch (final NullPointerException ex) {  }
        catch (final ArrayIndexOutOfBoundsException ex) {  }
        return s;
    }
    
    public static final String jlc$CompilerVersion$jif = "3.4.3";
    public static final long jlc$SourceLastModified$jif = 1501637906414L;
    public static final String jlc$ClassType$jif =
      ("H4sIAAAAAAAAAM08CXgV1blz7w1Z2ImsQeASIohCIou4RGRJiAQDRBIQAxom" +
       "cydkYHJnMjMXApb3oVRj8RU/KbhUQWpREVGs1ad1r5WCz6LS2kJtXYrve3XD" +
       "Vru413f+/5yZObPcmxuQ+vJ9OWfumfOf859//8859+45JnQzDWHYCqW51Fqj" +
       "y2bpHKW5VjRMOVGrqWvqSVOj9NmPfpW45TL9zaiQ2yDkK+bCpCk2yzVCgZiy" +
       "WjRDsdZYQt+aFeIqsSxlKWpZjWJa5TVCD0lLmpYhKknLbBP+Q4jUCH0V0iIm" +
       "LUW05ESVobVawsganUy0XNWsMrndKtNFQ2wtQ1TKaitU0TTJSLnYag+Srxva" +
       "KiUhG5YwooYgznqrYpOsltWydzXwqbzdEOL28Gx9dHE4Ml3d1jPLttx8Rd+H" +
       "YkKfBqGPkqyzREuRKrSkRfBpEHq2yq1NsmHOSCTkRIPQLynLiTrZUERVWUs6" +
       "askGodBUlidFK2XI5gLZ1NRV0LHQTOkERZjTbqwRelKSpCRLM+zl5DYrspqw" +
       "P3VrVsXlpiUMdMlCl1cF7YQW3Qk5ZaNZlGQbJGelkkwALXwQzhpLLiYdCGhe" +
       "q0z45UyVkxRJg1BIOaeKyeVldZahJJeTrt20lAUELko7aDkwQpRWisvlRksY" +
       "7O9XS1+RXgVICACxhAH+bjgS4VKRj0scf47Nu2DTlcnZySjinJAlFfDPJ0DD" +
       "fUAL5GbZkJOSTAF7nlFzkzjwqeuigkA6D/B1pn0e/c5H08cNf/YA7TM0pM/8" +
       "phWyZDVKO5t6Hzq1Yux5MSqCmqkA8z0rR+GvZW/K23WiWAOdEeFlqf3y2QW/" +
       "vGz9bvn9qNC9WsiVNDXVSuSon6S16ooqGxfJSdkAFakWCuRkogLfVwt55LlG" +
       "Scq0dX5zsylb1UKOik25Gn4mJGomQwCJ8sizkmzW7GddtFrwuV0XBCGP/AuF" +
       "5D+X/C9j9UJLWFh5/tKFpmxUkVHMpZWalGqViQIvXZhUllotsqmYSyXRlBtN" +
       "K5VQSA8i0Yzq+NhIFHKpaUj4YWmtSFhfSpr0kzVwO6yo7+pIhBD7VL+qq0RL" +
       "ZmsqMQeN0pbUzFkfPdD4YtQRfUYLS+gOQ5bikEIkgkP1B52gPCMUX0l0l9i0" +
       "nmPrLp+z7LriGBEWfXUOoRd0LfbYzgpXwavR1klEyn4zTV+26eyhF0SFbg3E" +
       "BpqVcrOYUq3aiplaKklsRX+naYFMzEgSjVeoAc3TJYSxhEEB00dNHgEz3EEA" +
       "bCiR7BK/foWh2afjnX/uvWmd5mqaJZQEDEAQEhS42E97Q5PkBDGJ7vBnxMVH" +
       "Gp9aVxIVcohVIGuzyMrAyAz3z+FR5HLbKMJaupHlNWtGq6jCK5sq3a0WQ1vt" +
       "tqBQ9MbnfoRLPUDUVfLfi3BsB6unwdtTdCj7UyECtvtWgUZ3ap2+7chL706K" +
       "ClHXPvfh/F2dbJVzNgEG64Pa38+VonpDlkm/12+p/cHWYx1LUIRIj1FhE5ZA" +
       "WUFsAfF6hMzXHGj7/Ztv7Hw16oqdRVxiqklVpHZnkdAudGeLu5DV53KLJLON" +
       "dvEhNkUldo2ga5YsTLZqCaVZEZtUGeT8yz6nTXjkg019qRyopIVS1RDGdT6A" +
       "2z5kprD+xSs+GY7DRCTwaS7N3G7UUJ7ijjzDMMQ1gEf7Vb8edut+cRsxucTM" +
       "mcpaGS1XDGkQI0CDXNVDaZcT1KrftWvPA+U9770LOVaA2kHcPq5iKGEUQNif" +
       "uyPvezlkhH9hGCPfJayexcsKmbfInRcHJygvRwQapV299r14bHDVARTyqKRY" +
       "wrCgBiUcrSjnbRER5JROjBBqOEM2uooMcap/iEWiR/kG+fFhyORcHk98HC9e" +
       "gsj0SMimZCi6LaIwnam06iphnGxPl2tpcwgjnMjKEJOmSjwRNS71+HJWu26A" +
       "X18lGshxpN2odhB3B41aCNgapXOu7zC0URungOh6dXJQGJ0v5ulsCXWw6lbN" +
       "0FsUKY4Li2vNcar+cdFYjg4kbimWKsMLLraKn94ENJQTcbFJWyXHm9bEr7Ra" +
       "FHPdWBj7fMLC0xBXe3mlFWIyqVm+RTZKuZLyyLGy5q9oeDDCCxPofcFZFdc2" +
       "Tv7JwShT7kF+JzJbNFuIETiiHm7Y+voZw+monJFg7x+vvGbrTY89Opn6mZ6E" +
       "OH2nTRfwD6kYt4RuuGoyx1A/6+vJMhn7b/pn/wVXX/rpQlSDqITyPoLIf3NK" +
       "Vec5DhDKc3RC7lkOiYk7jpu6LJEgN25zOV4MBCyOK8m46y6XUJAZmAfgrJfr" +
       "yOKpyMS+Ht8KHtrjK2s0SVRd/1D/n/sPT7n1nc1oL7qpvPvyR3o+SHWnur/m" +
       "72teogT1hwGcsjRKE3e3/iNanLsvKuQRV4wiQ/KRRaKaAvPcQMJrs4I11gi9" +
       "PO+9oTKNC8u5kHSKz1Hxip0DqLj2prfX3oxi8n9pmL2JCPgwF0GKsTwNitNt" +
       "V9CtWUmKKvMEX5O/CPn/F/zD2NAANcG+goWXcSe+tITW+cZyMamQuOzotZuP" +
       "brzr/G8ySptLHDwEaedPOGvcxCnjJ52LK6lATCdAMQmpMQsbBpAkElUByFtK" +
       "MxHUVigWURiHbKfBkiYwcsmsvsxjpqGa7ACcGQbQ6LU3S7KyNzrI8owmCMwk" +
       "q0t2p4GqBpbTw/W6l2d07Fn5b9FNaKr2kncao5IZRl4mlYk0UgmPl+CiFkDR" +
       "6LL8MmxdhkxFooSxdwbML7F5b2Z1KgN7F4UBbPSytyEr9tI9DbNzxnKERe6u" +
       "7Jy7eWxwryWkdhs9JjPc3f8hVjx584x5aAl74eaHbcEsYQgX+Nfyr8qpKXdo" +
       "AtZEaGK0uInV13tpQlOHOE4hk4yfXxWSAPJwTqjArfncIOLAu8EjNV9tn/q7" +
       "px9BNwgAQ3xxgWuNp7ywO/byoqXbaKDGpQSDuUVCVsXtOrDtjuHpyEB3O5AW" +
       "Fzu0OAVoUcKyXIPVIk8LgQr0leECHYPHsSTsNnF3iBNvS+jB0cwM+qpaQ2kl" +
       "ecEqtishX7dl49elm7ZEua2bUYHdEx6GW1AvnBJC0JGZZkGIqj/vXffErnUd" +
       "1CkWejciZiVTrff/7qtfld7y1gshGbHrfft6ZTVI6eK38zqq35lDYu0Y5rYV" +
       "GlqlJA2msKk66W3qoZgE3aSk6MRtwSTXQNEhRASfGUIzsJJJ7h1hZoCZoY3Z" +
       "mSHdNUMrsNX0BvPo+TH9oLzaP2nw1o4ffDKIiGeDkMciA4wR5mlJ/BCydcXB" +
       "/3XPm+//utewBzD+zmkifhNDAP+eX3BLz7NTh5j29BJlkW3i0tpGnzGtZx2v" +
       "SwvQ5gDMBoA61rGD1d85McMBcFtxhlWcnhGf3wP7UGhsKwPGObsr3oixCsjm" +
       "mg9p7dT/3fyvthKUvd4tIpE0ogOwMysbJOFR3E+W0M9vL8o7CzJ9kzWU7bm9" +
       "qOLC91FdXFuFQTW1NlBstkXyjnCRjKIh8diPXFVOLrdaXNncTBlSSZ8tYXqX" +
       "nD8lJceOJY7fx+oGbgqcbgsishWKW6G4DW18aKI/q1W3MDVf+9ighy+4Z/sb" +
       "NNUJss17oDAXpdkl5Tk/qiw59bm2Td/cfhjyMHzra4SPrX5k7p2754WLRksk" +
       "7Yg5u16BvXQvkD9rp7PWe0L84ZTMUN5DRQGK0chz/HymQzYByUajhIcyvHsY" +
       "ir3EOkuqlpR5ZkK5S9f1SEQQAqBhWWKtqBgs2Bj4cXGZXlX5FvpgDAlrNVWR" +
       "1sC2g3+LscJ5W476ZcnL7c7DAp2r3dfldpaJqvEEbHz5gwiGDx9IbBtw85OF" +
       "922eYe8eXBgaW4HL9S9vgSwmZIPO3Sh9vP01ecHZn31IN/C01Un/0ZFue6My" +
       "xy/BqZOBo8CczxI5GhygIRt+yvd37D32Ru10NAzcloo3imHHUxw5eutY/cK7" +
       "h+zgUlqv6Q46jdIVA18589QnL/sevxXhA+B6b7r39ry/jPtsBy7Z2dQZ5dvU" +
       "cQAybuxAeZ7ejvuHHqbxCPJ8GzTg9VcPrJr9IUXVz+kwiGkT+z/9zuAhV7KQ" +
       "EWZ8Xqcm6oAexuBLDcVyGRwvrXnumbwF/80xGLlGlr4aO1IeQvlzSvSXnC0g" +
       "Hw1napaltXKUnDrqtRXlXx162BbCfUiJsd5F+aA8W0hnPDFk0x/Wz7fhX6DL" +
       "e5kt7xD9+BhTjd/ipyfDBR0an6H4HwkbxPfxIO36up+c3o/tsIUwOJ3nwE5X" +
       "sagTqu9aQozoPZo16uh24iy7obiPRlwrs/QzPBy+OyuD8XsXingkEjRvSD8o" +
       "RhJf2TdBHUdcZzkevHifUpUu/RnaFcoPKS1og4c8waaDLtjfKLW5PjYDPE3I" +
       "T/phMNuyhufbnTgLTt8w1c4n/8+y+n546wtvP0sTS5CMkkgu0WyZBhTew4B+" +
       "bMQ9rL6DG9nZQUTueDEazvr/LAyjb3pLggwXiabdloAW3CXoi4RgPX0UHE/+" +
       "C8j/X1j9apCCkdwM0dhX6YgHg/2G1b/0EC9kmyaEiAD3VhhSJ4OIvbMmYu8w" +
       "Ik4V8Jwscharu4UQsfB4iAiD5dBa+MRDRGc3JIR8kxnkmDB0fOnK6QAwiXUc" +
       "zeqhPMBxpSuRokC6coMXSRu5orRITgjqOnQcnMWqhgBACes4iNU9T3xVxfyq" +
       "0BYHwncUD+g7wub8mCyTGSjudCw+gXcSGfJ8MhIZewqcDq1zBONscDARDLZ3" +
       "hy5vD4WFshQ+P5je80QmZXh3NhTo3R7pHKd0ATp8fqINvUVGZwxd3kaUKVfO" +
       "dDwvUdsIp+FF7VzG4UgU/uWy/3pWz+MkinNVwRyuLkWsHXctZ/Hpi37+3SHm" +
       "9TTIG+skWXK7VYoCyUD9cL8/EpvYwyq5AWM1Z08kn8RtJvS0hHj6C2E4Fg2e" +
       "ezjLwossoILdCdoiq+dZwvllLVqrXLZCTpSt1oyVZRD6Jkjqig+q0jTeNCT6" +
       "DMc5ZIX0RIfdVjkBaOT4dHt/oxCoiEcaTie8XxKgbaPU77zbmpqvnr4fE4k+" +
       "SA7kfB0lzGjvnigDKqnz9vPeeQvlRqP0zt7vHxj53qJT8DKTTXj+SsNcUS/3" +
       "X2GA00nS3i3vtZ//YuCyQzEhWiV0VzUxUSXibRChwGoxZLNFUxPtOotaI6sh" +
       "gog6euc6iKHwehxjl8nqJiDdTJThCrYjG0lz8BVz7kA4u7IndBSmE6ZHapx4" +
       "N1KPYnYtPFZi63WEQpK9uUljS1uZXatdDuNXMd3awurvnbjVbuCtdjtkICVh" +
       "EuQXhgnl0rzntPPGokTlgnktOQvvYYQIUjlmIJE5MPiwdNfxcMt359Vbtifm" +
       "3zXBTmmusQjrNX28Kq+SVc6I5FNT6xAH7+HEBTz3jxmsvpwnDtqwMNvl3G4B" +
       "kKWsXuS3XeE2ekWGd5AeRGRLyF8uW/UhATGiPIjNp4ShfDJiufTndNCyKFMS" +
       "FKE34j6Ax1SnyaQDEGl38h7S4E+FfE0HXbB1Tt5j9+FSIbcJnVuYNMDJ90hC" +
       "0idY/eOuSQOA3Mnq27OTho4M70BRI1dbQg8iDWmCe0cgYMq9YVifDIH4/gkI" +
       "xAZXIDZnJRAIENnqcn9DUCA2BAWCgv3Q5f6GoEBs6FQgzhUwTM4ZSevY37sm" +
       "EADyN1Yfy04gdmZ4dzcUdxCCg0CEZiuI9HiG9MAwpH0eYqTt9wBgAKu78wDH" +
       "5yF2Z8hWHMMLcxWkRdK3quEMIC+LVWF6M4wB5DKAL058VQ8FshUSRMMl3QwC" +
       "v8MV+EezEngEiDzuSveOoMDvCAo8BXvGle4dQYHf0anAj6f/OS+xek/XBB5A" +
       "7mP1XekFns99XDaXwiiTGfRvWf1ygM2TYSUvZn0hT4NGeoAZl9tSomqGXYs5" +
       "unHn0Ws348WYyK+oeUvPJkzX9lFywOMvMy2PYstjDuVBjG5e0r/V8YKX0xYm" +
       "Vya11UmaG9X12JPa8NT4I3ZgxY77cb4/ZjBTb0HxPImDKbnh0xvhB0GBjXQ2" +
       "PzsL6l/2wbb5nx590EbgHLounc+7I2/7GkncrFHt8wrWFCZQh8MEyxL62Tu1" +
       "RHDiTewQL/JuVhr7Hi7b3b4lDQGNfS+osRTM3b61+/Aa622qpk1sG+RTqopY" +
       "prlm4BDDe52NJX5+GYLiXyhHoQuGN69A8QWSBlGA4kt8czi9REQjKBFQ/CnM" +
       "tI9mLNkfZnTCzgvnaIotI/3y33zrmFE8xT4vbNW1pMxOZEeRliSaA2Utu1Ps" +
       "u5RUGDb9T/np8cqQ79DImZ4/WfnDocN337mxR7NzPKjjoU6nN9TrZGv9sM2H" +
       "brht/UIbdFwI+WMnIZCL9kwbyPkcKmwRYnQM9Hme1T/zatBxONRo30CYEGLT" +
       "oHwNJNkVO3bK7zsKymvSNFUWkxn9MbWLH9ABuEMYsCGuuu4LavC+oAbjWNGR" +
       "rrruC2rwPo/P9S7D1Z5fZ9Ce0/3aA40xHDaaA0Uus37RPFoVhMkP8tuleRo6" +
       "/9ZPZ4AY+G8m6LldImhUGxNG0RcyUHRaFhSFagalalrz32VKQ2tVW2YL61sR" +
       "IjwjazZAxzlZeS1K67nHx6IFXWBRWJwJd59nC0J+nNZ5n7cJXYkzAeQzVv+N" +
       "A/XxPErPBXw+ZyKMcg5DYDSrR/IIOHyLXkEM28Ks4ky1Se1qpBltzCbSjC52" +
       "IrnoZZkWSPHlcYdyGUqyqH9j40Gh0jGhlCwhRtbuC7mQxuWMtmeE0Rjk5H0Y" +
       "IJmNtEY1nNxwRJM0+KXV13TQBVvtiKbdh5NWX1M1baIxVvQ7ncdY0K0VnjbY" +
       "lBE2+CQOjjOFakaFc1k9Llzi1p+8zCZ6VQZ5Y7wMBM+Iex3DeWYY7g4nr82K" +
       "kx041UaXbR1BTnYEOUnBbnDZ1hHkZEeQkx02J7dkx8lroENkqrN8PM8ZRs1W" +
       "pIrVZ1nC1C6dyFRXsi9QkgCNHemc2ABIjJsRSxLaD3BOdfh+uJIqLC/u9AAE" +
       "tlfQBMD6FrP6IpjlViTfD9kBSDTNTdKTfAASvds5AInCTZ3I4rD0sXJNUmxV" +
       "JJYa3PPyLx798aD68fRGOXzfPOwS4QxJkk2zlrz1f2OhBpCbzyT+QlaX85Jv" +
       "CVMSdEqmpYasG7JJlJOoIFE+iM+RBHERZ4kDEuAp9OD1NR53Pq9478Eb35n0" +
       "/Iu3evKKEf6Vu6vAL6NNqC4654KG/3oOryIXJOVVsjEvpao1QlRVQr7h7PkC" +
       "m+c6aXsIld25FmiadfaN6gM/PfvdpfTkNfhdVKezlnNe+UVPzB4d9fxkAczS" +
       "h0Zb9wtocak/aUepiVwBTdvQdqHEo9xnOEKJQlISvbTzzYc2tnVAvGFwP4Fv" +
       "pOigo0L0OPtOzTVvuqG8GhezAcsWFk5HUXC3uEuQMyxhHy4Bisd9fgRDJ9ub" +
       "DgkLnWgI6wAUhgDkR3iAzjOHnHQRBVuglzw4zG4HAUwch7KJWeSWn/cN6RBM" +
       "tZdWP4HiFV6AEAU3gz0VEBnDEBjI6h5eRI4ng6XRrT+D7VwUssisWKAWzKxA" +
       "PF1fuTjoPhcH3SeOFX3b9ZWLg+5zsSdst4QcQsYxXZF8KN7DJWcKMWh6w+hA" +
       "3S083oLvj6GFz+y62mw3FN2NduP4ZQjA/0rlKG3UQmXLMU5IFN46fYh4L82g" +
       "0J/6FRoe93Pp5gtUGj6nqpgek+zUE4qvUUUzccHHXJecr5wQOWPRrMj5ioec" +
       "riL5pCmW3zVpwsbPs9YsmKFnVkErAsT6HJfWxfp3Qevw2Zcsw5XCWmKuvmb1" +
       "0TahK8kygPyJ1X/gQH0SG34oMxZGOZtCF/RktcAj4PAtFj95qUtsZIbUhdIM" +
       "ehU5qW1saKblUWx5zKEshhXFRunf5nhgVt5A6AnpLUpsEhRDso9yyMTBKIdv" +
       "DEn8kPOVjONDwzjfxhK/WHk2OhS7AFGf5igMafDrkK/poAtW6SiM3YfTIV9T" +
       "NW2iiV+MfoEzq2MSzhHF5rZ17ohwzM5yqG8/V6SZW6w2nBCwXxm5BApIgCN1" +
       "yNZ6yL7gAd0WzbigaOA8X2xeQOChWIxCn85kx2DmWA1KDXIHaY1vxmUQ+CUo" +
       "8FBM9hkotJAjmXn7NMxCUj/rABSGAbzLA3QeE0d90SV+oXs4G+sfrH6PH/O4" +
       "osuYFBpd+swLlGUsumREzSK6ZLYoGF2CWXAVsiioo0VBHcWxYm2uQhYFdbTI" +
       "F13y+LpCMCaDELT7hQAeL3fjqFhjNqxz6ZqGlmf8f6DldV2iJQ2CAsQcnoGY" +
       "N2RBTKhupARNa9u7QmQobmrLbB58i8HG");
    public static final String jlc$ClassType$jif$1 =
      ("G7PmADz+MCtvRMm87fi4c2cXuEO9v9dewTcp6ok7TbF6aZvQlYgOQJaweiEH" +
       "moHdezK8ewCKeywhv0U0W+D3wMJM7FA2nxqGss8c9gGAItZxJauX8QDHZw4D" +
       "96/ezigTu1yZyOrqFQWIuVevSENAJnYFZYKCuVev7D68TOzqVCZgc0Ihz0dZ" +
       "zX/HKwuZAJB9rH4mO5nIcEQaexGK54lMWBr98aMwmRjO5vt9GMo+mXDu5EHH" +
       "I6w+eOIy8bJfJjLeP425x6SxV7OSCQSIHXYFIHhMGgsekzKwP7oCEDwmjXmP" +
       "Scn6uzm/ajM48DvB9LdtpQe298kftH3hYfojHvaPfRWw31Hjf+OLe84l6Xuz" +
       "gisvwJJ+2Tv2Nsm/gZrw/D94/v9lO80iBvOEC5eQP3t/8hB+WCFFfyO5Ufrr" +
       "xAmVTx8YvZ995zrtF0BciL3b58y78qMp9EcSuxFGr10Lk+bXCHk0eUQc4Fcf" +
       "R6YdzR4rd/bYL3o/WHCa8zt/UBRyOuRZ3WA3HbiyPWxv3fMjzo3SSmHd9c93" +
       "FF6FP8NSoJj1Rsq04OeUCyT7ewkw1hp6mkC/SR37Cxl4jP+r59yw/I5/ZMWt" +
       "82vyvl6c+YcG6Des/g/daPnIMlsAAA==");
    
    public Paper(final jif.lang.Label jif$AuthorLabel) {
        super();
        this.jif$conf_Paper_AuthorLabel = jif$AuthorLabel;
    }
    
    private void jif$init() {  }
    
    public static boolean jif$Instanceof(final jif.lang.Label jif$AuthorLabel,
                                         final Object o) {
        if (o instanceof Paper) {
            Paper c = (Paper) o;
            return jif.lang.LabelUtil.singleton().
              equivalentTo(c.jif$conf_Paper_AuthorLabel, jif$AuthorLabel);
        }
        return false;
    }
    
    public static Paper jif$cast$conf_Paper(
      final jif.lang.Label jif$AuthorLabel, final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(jif$AuthorLabel, o)) return (Paper) o;
        throw new ClassCastException();
    }
    
    private final jif.lang.Label jif$conf_Paper_AuthorLabel;
    private jif.lang.Label jif$jif_lang_JifObject_L;
    
    public final jif.lang.Label jif$getjif_lang_JifObject_L() {
        if (this.jif$jif_lang_JifObject_L == null)
            this.jif$jif_lang_JifObject_L = this.jif$conf_Paper_AuthorLabel;
        return this.jif$jif_lang_JifObject_L;
    }
    
    private jif.lang.Label jif$jif_lang_IDComparable_L;
    
    public final jif.lang.Label jif$getjif_lang_IDComparable_L() {
        if (this.jif$jif_lang_IDComparable_L == null)
            this.jif$jif_lang_IDComparable_L = this.jif$jif_lang_JifObject_L;
        return this.jif$jif_lang_IDComparable_L;
    }
    
    private jif.lang.Label jif$jif_lang_Hashable_L;
    
    public final jif.lang.Label jif$getjif_lang_Hashable_L() {
        if (this.jif$jif_lang_Hashable_L == null)
            this.jif$jif_lang_Hashable_L = this.jif$jif_lang_JifObject_L;
        return this.jif$jif_lang_Hashable_L;
    }
    
    private jif.lang.Label jif$jif_lang_ToStringable_L;
    
    public final jif.lang.Label jif$getjif_lang_ToStringable_L() {
        if (this.jif$jif_lang_ToStringable_L == null)
            this.jif$jif_lang_ToStringable_L = this.jif$jif_lang_JifObject_L;
        return this.jif$jif_lang_ToStringable_L;
    }
    
    public static final String jlc$CompilerVersion$jl = "2.7.0";
    public static final long jlc$SourceLastModified$jl = 1501637906414L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAOW8C8w0WXYQ9v3/7szs0/vwa1l71/96x8use3eququrq3vH" +
       "a1Kvrqququ6ud3V5lnG934+ud5VZZKLEtoxkIrImjgQWIrYSYLEjFCuKLCtW" +
       "FByQiVEsFIgQMawQCTIOQbwRYKr7+/7H/PPP7x2BMYhPuo+65z7OOfecc89t" +
       "nft99TduXqjKmwdFngx+ktev1kPhVq8ezbJyHTwxq0qeGt6wf3wGfOW/+r0f" +
       "/rPvuvmQcfOhMJNqsw5tPM9qt6+Nmw+kbmq5ZYU6jusYNx/JXNeR3DI0k3Cc" +
       "OuaZcfPRKvQzs25KtxLdKk/aS8ePVk3hltc1HzZyNx+w86yqy8au87Kqbz7M" +
       "RWZrAk0dJgAXVvVr3M2LXugmTnW++f0397ibF7zE9KeO38I9pAK4zghsL+1T" +
       "9/eFE5qlZ9ruwyHvjsPMqW++4+kRjyh+mZ06TENfSt06yB8t9e7MnBpuPnqL" +
       "UmJmPiDVZZj5U9cX8mZapb75+NtOOnV6T2Hasem7b9Q3H3u63/EWNPV675Ut" +
       "lyH1zTc/3e06U1/efPypPXtit35j/z0/9gMZnd2/4uy4dnLB/4Vp0CefGiS6" +
       "nlu6me3eDvzAd3N/xPyWX/iR+zc3U+dvfqrzbZ//8ff9/f/kc5/8xT9/2+fb" +
       "ntHnYEWuXb9h/5T1Df/Ht+Of3bzrgsZ7irwKL6LwJsqvu3q8g7zWF5Msfsuj" +
       "GS/AVx8Cf1H8pdMP/in31+/fvI+5edHOkyadpOojdp4WYeKWlJu5pVm7DnPz" +
       "Xjdz8CucuXlpqnNh5t62Hjyvcmvm5t3JtenF/Po9scibpriw6N1TPcy8/GG9" +
       "MOvgWu+Lm5ubl6Z089EpvTil778rlfpGIb7wulK55XaapXqdyO0mdbO6el3J" +
       "wtfrwK3C6nXbrNw3qrpxwqnHJN93XL9W34hC7/WqtK8frx/NaetfnZqK366J" +
       "+wtFH+zu3ZuY/e1PK34yaQmdJ45bvmF/pcHIv/8zb/zy/Ueif8eL+uZ9lylf" +
       "vU55c+/edapvuujE7Z5NHI8nTZ6U9QOflb60+/4f+c53TcJSdO+e+HXp+vLT" +
       "ovtY4ZmpZk4EvGF/6If/33/8s3/ky/ljIa5vXn6Lbr115EU3vvNpssrcdp3J" +
       "9jye/rsfmD/3xi98+eX7l41+70RObU5CMenvJ59e40068tpDe3NhxX3u5v1e" +
       "XqZmcgE9NBLvq4My7x63XPn9/mv9G35z+rs3pX91SRdxujRcysmo4Hei/OCR" +
       "LNc36aH0zSycZOBrP/SHv/ajP/2Ff5sSwU8UXwTiC3Pwc4vV56F1cSsal818" +
       "ioFXU/pFqfhjf/VX/g50/0L4Q6v7oSfMs+TWrz2h6ZfJPnDV6Y88lg25dN2p" +
       "31//ieN/+eO/8cPfdxWMqcenn7Xgy5f8whZzYkde/ud//vx//dr//VN/+f5j" +
       "YapvXiwaKwntK+bfPk30mcdLTUYgmQzRhEn1spKluRN6oWkl7kUw/8WHvmv+" +
       "c3/3xz58K13J1HK7V+XN537rCR63/y7s5gd/+ff+k09ep7lnXw6hx+x43O3W" +
       "sn3j45nRsjSHCx79H/jVT/zX/5v5xyYbOdmlKhzdq6m5d6crF6Q+Wt98w7RL" +
       "r16Om1c503KTK7GfuwJ/9zWfXUToOuTmCgMv2bf1V9g3X9s/UL3V+G8vp+hj" +
       "jTCAr/7Rj+Pf++tXWh5rxGWOj/dvNRWq+YSyLv5U+o/uf+eLf+7+zUvGzYev" +
       "B7iZ1aqZNJfNNqYjuMLvGrmbD74J/ubj9PbseO2Rxn/709r4xLJP6+JjEzXV" +
       "L70v9ZeeVL87+33zXVN6z5R+8a78Mxfoh4tL/pH+3s21sroO+Y5r/p2X7Lse" +
       "itxLRRm2k37eylx980Id1on7cK8+fN3l62bd+ga3OnXJF2/G4vNTeu+U/t5d" +
       "+ZefgcX3vg0Wl+oXHiLwweJiiFFrMoWmfRXk73nbRb84pfdPE4B35QvPWBT/" +
       "ehZ9yWwm16isqre6IlfpvvUW/v+v/tqv/+oHP/EzVzP7bmuyTddNedqHe6uL" +
       "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" +
       "q1V6I0G6Sy7cWKMcGHVFSuSG7brRACVA");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "efkxTk9R8mBKn5gWKe/KL70zSi5DXr8r1ben5En0/vvnwP7sJfvT9c17fLeW" +
       "Lw8JrmQ/C+9PT+lT06I/f1f+N+8M78uQP3FX/tGvD+//6Tmwn79k/8PE8gnv" +
       "Nz09eBbq65vro4t3f+q2fNc/fGeoX4b8g7vyN74+1P+X58D+10v2C/XN+y6o" +
       "P46vZ56F+edv07t/5a786jvD/DLkT9+VP/32mN977OxE11l/+Tno/++X7Jfq" +
       "mxfdyY4l1bMCl1+y8jxxzexZFM2nRN/cvOfBbfnSP39nFF2G/LO78h+8PUX3" +
       "HzuIn39otL75kdF68ki+rvlXnkPvX7tkv/qI3svXX3oWYa9M6TgR9pt35dfe" +
       "GWGXIX/zrvxrX9dW/dXrrF97Dup/65L99d8a9Zdvrqb/vc1d+fo7Q/0y5Pvu" +
       "SuXr049ffw7sqmJ/ezJJweQA4LlzNUnas/D+3VMKp/rX7spfemd4X4b8ubvy" +
       "f/768P6Hz4H940v29ya86/zx06un7dHlvdfNR27e4pj87L+njkmbh87V/wiz" +
       "sH7lsw9+4MH3fUl68OXJ63iawb+V83WB/vOieA4D/9Xbw+5dh//TibkPcXnm" +
       "g4kLtk8x/IrQJ97C8Hs/9+8Zw28frjy4fU/64M6AXjn/8LVO7r3yfddnVF+H" +
       "t/jEvfdzD+4Gma359Khb1+12WP6l7bS9offglfxB+GjJB1dv5rLv18oD+8EX" +
       "H7xy25a/9uD2wdCDN78PVS5vpqpJ/hO3zrNXPvvqZH0mYUom1sn5K/arb39F" +
       "/9xTqH/2tS/freBN5st97Wmxe+YPAp+5ZMXdi9y3PxUeHXb33v8csfvgJXvh" +
       "9gnsExvxFkv68CH1xx4K2MOGC/QTvx1Yf9NzsP6WS/ahyw8tF1abVf0Evx8j" +
       "8hTq3/RvhLr0TNSfROoTz4FdDMi9j93dYya36G1/dvidQPwzz4G9csk+Vd98" +
       "8mnEn3Hr/53AHXgO7PKb273vvvvN7Encn7p4/07gvX4O7PKL3z3oGTx/xr23" +
       "r29euIr95QX8x97yf2Zu/xuK/TM/+aH3fOtPKn/l9pnww/9Y8iJ38x6vSZIn" +
       "33U/UX+xKF0vvFLy4u0r7yv19753Oocu6nap/57iVmH/NYa6n+DpRgAA");
}
