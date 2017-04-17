package battleships;

import jif.util.*;

/**
 * This class represents a player in the BattleShip game.
 *
 * A player has a secret Board that contains Ships. The player
 * initially generates a Board by placing Ships on the Board before the game 
 * starts.  That Board is then endorsed by the Opponent player (also an object
 * of this class), and stored.
 * 
 * During the game the Player generates a query to ask the Opponent
 * (the method getNextQuery), the Opponent endorses the query (the method 
 * endorseQuery), and the Opponent processes the query (the method 
 * processQuery()). Processing queries requires declassifying some 
 * information about the board. 
 *
 * This class also keeps track of which queries the opponent has
 * asked, to ensure the opponent doesn't repeat a query.
 *
 * This class is parameterized by the prinicipals P and O. P is the
 * principal that this Player class represents, and O is the opponent. The 
 * secret board is instantiated with the label parameter {P->*;P<-* meet O<-*}; 
 * i.e., the information is readable only by P, but trusted by both O and P.
 */
class Player {
    /**
     * This Board represents P's board. 
     * It's fine to make the reference to the board public, as all the 
     * information contained in the board is readable only by P
     */
    private Board board;
    /**
     * Record which queries the opponent has made, to stop them from
     * repeating queries.
     */
    private List opponentQueries;
    
    public Player battleships$Player$() {
        this.jif$init();
        {
            this.opponentQueries =
              new LinkedList(
                jif.lang.LabelUtil.
                    singleton().
                    toLabel(
                      jif.lang.LabelUtil.
                          singleton().bottomConf(),
                      jif.lang.LabelUtil.
                          singleton().
                          writerPolicy(this.jif$battleships_Player_P,
                                       jif.lang.PrincipalUtil.topPrincipal()).
                          meet(
                            jif.lang.LabelUtil.
                                singleton().
                                writerPolicy(
                                  this.jif$battleships_Player_O,
                                  jif.lang.PrincipalUtil.topPrincipal()),
                            true))).jif$util$LinkedList$();
        }
        return this;
    }
    
    /**
     * Create an initial board by placing ships to cover numCovered coords.
     */
    Board init(final int numCovered) {
        final Ship[]
          myCunningStrategy =
          { new Ship(
              jif.lang.LabelUtil.
                  singleton().
                  toLabel(
                    jif.lang.LabelUtil.singleton().
                        readerPolicy(this.jif$battleships_Player_P,
                                     jif.lang.PrincipalUtil.topPrincipal()),
                    jif.lang.LabelUtil.singleton().
                        writerPolicy(this.jif$battleships_Player_P,
                                     jif.lang.PrincipalUtil.topPrincipal()))).
          battleships$Ship$(
            new Coordinate(
              jif.lang.LabelUtil.
                  singleton().
                  toLabel(
                    jif.lang.LabelUtil.
                        singleton().readerPolicy(
                                      this.jif$battleships_Player_P,
                                      jif.lang.PrincipalUtil.topPrincipal()),
                    jif.lang.LabelUtil.singleton().
                        writerPolicy(this.jif$battleships_Player_P,
                                     jif.lang.PrincipalUtil.topPrincipal()))).
                battleships$Coordinate$(1, 1), 1, true),
        new Ship(
          jif.lang.LabelUtil.singleton().
              toLabel(
                jif.lang.LabelUtil.singleton(
                                     ).readerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal()),
                jif.lang.LabelUtil.singleton(
                                     ).writerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal(
                                                                  )))).
          battleships$Ship$(
            new Coordinate(
              jif.lang.LabelUtil.
                  singleton().
                  toLabel(
                    jif.lang.LabelUtil.
                        singleton().readerPolicy(
                                      this.jif$battleships_Player_P,
                                      jif.lang.PrincipalUtil.topPrincipal()),
                    jif.lang.LabelUtil.singleton().
                        writerPolicy(this.jif$battleships_Player_P,
                                     jif.lang.PrincipalUtil.topPrincipal()))).
                battleships$Coordinate$(1, 3), 2, false),
        new Ship(
          jif.lang.LabelUtil.singleton().
              toLabel(
                jif.lang.LabelUtil.singleton(
                                     ).readerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal()),
                jif.lang.LabelUtil.singleton(
                                     ).writerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal(
                                                                  )))).
          battleships$Ship$(
            new Coordinate(
              jif.lang.LabelUtil.
                  singleton().
                  toLabel(
                    jif.lang.LabelUtil.
                        singleton().readerPolicy(
                                      this.jif$battleships_Player_P,
                                      jif.lang.PrincipalUtil.topPrincipal()),
                    jif.lang.LabelUtil.singleton().
                        writerPolicy(this.jif$battleships_Player_P,
                                     jif.lang.PrincipalUtil.topPrincipal()))).
                battleships$Coordinate$(2, 2), 3, true),
        new Ship(
          jif.lang.LabelUtil.singleton().
              toLabel(
                jif.lang.LabelUtil.singleton(
                                     ).readerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal()),
                jif.lang.LabelUtil.singleton(
                                     ).writerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal(
                                                                  )))).
          battleships$Ship$(
            new Coordinate(
              jif.lang.LabelUtil.
                  singleton().
                  toLabel(
                    jif.lang.LabelUtil.
                        singleton().readerPolicy(
                                      this.jif$battleships_Player_P,
                                      jif.lang.PrincipalUtil.topPrincipal()),
                    jif.lang.LabelUtil.singleton().
                        writerPolicy(this.jif$battleships_Player_P,
                                     jif.lang.PrincipalUtil.topPrincipal()))).
                battleships$Coordinate$(3, 4), 4, false),
        new Ship(
          jif.lang.LabelUtil.singleton().
              toLabel(
                jif.lang.LabelUtil.singleton(
                                     ).readerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal()),
                jif.lang.LabelUtil.singleton(
                                     ).writerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal(
                                                                  )))).
          battleships$Ship$(
            new Coordinate(
              jif.lang.LabelUtil.
                  singleton().
                  toLabel(
                    jif.lang.LabelUtil.
                        singleton().readerPolicy(
                                      this.jif$battleships_Player_P,
                                      jif.lang.PrincipalUtil.topPrincipal()),
                    jif.lang.LabelUtil.singleton().
                        writerPolicy(this.jif$battleships_Player_P,
                                     jif.lang.PrincipalUtil.topPrincipal()))).
                battleships$Coordinate$(5, 6), 5, true),
        new Ship(
          jif.lang.LabelUtil.singleton().
              toLabel(
                jif.lang.LabelUtil.singleton(
                                     ).readerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal()),
                jif.lang.LabelUtil.singleton(
                                     ).writerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal(
                                                                  )))).
          battleships$Ship$(
            new Coordinate(
              jif.lang.LabelUtil.
                  singleton().
                  toLabel(
                    jif.lang.LabelUtil.
                        singleton().readerPolicy(
                                      this.jif$battleships_Player_P,
                                      jif.lang.PrincipalUtil.topPrincipal()),
                    jif.lang.LabelUtil.singleton().
                        writerPolicy(this.jif$battleships_Player_P,
                                     jif.lang.PrincipalUtil.topPrincipal()))).
                battleships$Coordinate$(5, 7), 6, false) };
        Board
          board =
          new Board(
            jif.lang.LabelUtil.
                singleton().
                toLabel(
                  jif.lang.LabelUtil.singleton().
                      readerPolicy(this.jif$battleships_Player_P,
                                   jif.lang.PrincipalUtil.topPrincipal()),
                  jif.lang.LabelUtil.singleton().
                      writerPolicy(this.jif$battleships_Player_P,
                                   jif.lang.PrincipalUtil.topPrincipal()))).
          battleships$Board$();
        int i = 0;
        for (int count = numCovered; count > 0 && board != null; ) {
            try {
                Ship newPiece = myCunningStrategy[i++];
                if (newPiece != null && newPiece.length > count) {
                    newPiece =
                      new Ship(
                        jif.lang.LabelUtil.
                            singleton().
                            toLabel(
                              jif.lang.LabelUtil.
                                  singleton().
                                  readerPolicy(
                                    this.jif$battleships_Player_P,
                                    jif.lang.PrincipalUtil.topPrincipal()),
                              jif.lang.LabelUtil.singleton().
                                  writerPolicy(
                                    this.jif$battleships_Player_P,
                                    jif.lang.PrincipalUtil.topPrincipal()))).
                        battleships$Ship$(newPiece.pos, count,
                                          newPiece.isHorizontal);
                }
                board.addShip(newPiece);
                count -= newPiece == null ? 0 : newPiece.length;
            }
            catch (final ArrayIndexOutOfBoundsException ignored) {  }
            catch (final IllegalArgumentException ignored) {  }
        }
        return board;
    }
    
    /**
     * Store the endorsed board.
     */
    void storeBoard(final Board board) { this.board = board; }
    
    /**
     * Endorse the opponents board.
     */
    Board endorseBoard(final Board b) {
        Board brd = b;
        if (brd == null) return null;
        return brd.endorseBoard(this.jif$battleships_Player_O,
                                this.jif$battleships_Player_P);
    }
    
    /**
     * Endorse a query from the opponent.
     */
    Coordinate endorseQuery(final Coordinate qu) {
        Coordinate query = qu;
        if (query == null) return null;
        int x = query.x;
        int y = query.y;
        return new Coordinate(
                 jif.lang.LabelUtil.
                     singleton().
                     toLabel(
                       jif.lang.LabelUtil.
                           singleton().bottomConf(),
                       jif.lang.LabelUtil.
                           singleton().
                           writerPolicy(this.jif$battleships_Player_P,
                                        jif.lang.PrincipalUtil.topPrincipal()).
                           meet(
                             jif.lang.LabelUtil.
                                 singleton().
                                 writerPolicy(
                                   this.jif$battleships_Player_O,
                                   jif.lang.PrincipalUtil.topPrincipal()),
                             true))).battleships$Coordinate$(x, y);
    }
    
    /**
     * Generate the next query to ask the opponent.
     */
    public Coordinate getNextQuery() {
        Coordinate c = this.nextQuery;
        if (c == null) {
            c =
              new Coordinate(
                jif.lang.LabelUtil.
                    singleton().
                    toLabel(
                      jif.lang.LabelUtil.
                          singleton().readerPolicy(
                                        this.jif$battleships_Player_P,
                                        jif.lang.PrincipalUtil.topPrincipal()),
                      jif.lang.LabelUtil.singleton().
                          writerPolicy(this.jif$battleships_Player_P,
                                       jif.lang.PrincipalUtil.topPrincipal()))).
                battleships$Coordinate$(0, 0);
        }
        boolean direction = (c.x + c.y) % 2 == 0;
        int newX = c.x + (direction ? 1 : -1);
        int newY = c.y + (direction ? -1 : 1);
        if (newX < 0) newX = 0;
        if (newY < 0) newY = 0;
        this.nextQuery =
          new Coordinate(
            jif.lang.LabelUtil.singleton().
                toLabel(
                  jif.lang.LabelUtil.singleton(
                                       ).readerPolicy(
                                           this.jif$battleships_Player_P,
                                           jif.lang.PrincipalUtil.topPrincipal(
                                                                    )),
                  jif.lang.LabelUtil.singleton(
                                       ).writerPolicy(
                                           this.jif$battleships_Player_P,
                                           jif.lang.PrincipalUtil.topPrincipal(
                                                                    )))).
            battleships$Coordinate$(newX, newY);
        Coordinate
          d =
          new Coordinate(
            jif.lang.LabelUtil.
                singleton().
                toLabel(
                  jif.lang.LabelUtil.singleton().bottomConf(),
                  jif.lang.LabelUtil.singleton().
                      writerPolicy(this.jif$battleships_Player_P,
                                   jif.lang.PrincipalUtil.topPrincipal()))).
          battleships$Coordinate$(c.x, c.y);
        return d;
    }
    
    private Coordinate nextQuery;
    
    /**
     * Process the query of the opponent. Note that the method requires
     authority
     * to declassify the result of processing the query.
     *
     * @throws IllegalArgumentException if the opponent has asked the query
     already
     */
    boolean processQuery(final Coordinate query)
          throws IllegalArgumentException {
        Board brd = this.board;
        List oppQueries = this.opponentQueries;
        if (brd == null || oppQueries == null || query == null) {
            throw new IllegalArgumentException("Bad state or args");
        }
        if (oppQueries.contains(query)) {
            throw new IllegalArgumentException(
                    "Opponent already asked the query " + query.toString());
        }
        try { oppQueries.add(query); }
        catch (final ClassCastException impossible) {  }
        boolean
          result =
          brd.
          testPosition(
            query,
            jif.lang.LabelUtil.
                singleton().
                toLabel(
                  jif.lang.LabelUtil.singleton().bottomConf(),
                  jif.lang.LabelUtil.
                      singleton().
                      writerPolicy(
                        this.jif$battleships_Player_P,
                        jif.lang.PrincipalUtil.
                            topPrincipal()).
                      meet(
                        jif.lang.LabelUtil.
                            singleton().writerPolicy(
                                          this.jif$battleships_Player_O,
                                          jif.lang.PrincipalUtil.topPrincipal(
                                                                   )), true)));
        return result;
    }
    
    public static final String jlc$CompilerVersion$jif = "3.5.0";
    public static final long jlc$SourceLastModified$jif = 1492411775999L;
    public static final String jlc$ClassType$jif =
      ("H4sIAAAAAAAAAL09CXQUVbbVnSYBwhL2sIUmBGRNgEFQoyIEkWCECAQhgKHS" +
       "XSENna5OV3UIIjO4gSsq4jYiI/NxHYWZOeM4I4vLqOC4jY4j6IyO4z9/PqPi" +
       "9l3nD/rfvXW7llevqjs5f+Qc6lVe3Xvffffd7d16qTx8QuqipaTha2NN5fqG" +
       "pKKVz4811copTYnWqvENS1hXQ+Sb3S9G71ie/GtQyq+Xusa0uoQmNyk1Ujc5" +
       "rTerqZi+QZeKatbKbXJFWo/FK2piml5ZIxVG1ISmp+RYQtdapR9KgRqpKMZ6" +
       "5IQek3UlOjeltujSyJokG2hNXNUrlHa9Iimn5JYKZKWitiouaxqjlI+9GSJd" +
       "kym1LRZVUro0ooYxTtBxuVGJV9TSsxr4qbI9JYUz5Gl+xuSQsjG7WydU7Lj9" +
       "4qJf5km966XescRiXdZjkSo1oTN+6qUeLUpLo5LSZkWjSrRe6pNQlOhiJRWT" +
       "47FLGKCaqJf6arE1CVlPpxRtkaKp8TYA7Kulk4xFGDPTWSP1MESSjuhqKjOd" +
       "/KaYEo9mfurSFJfXaLo00BKLMb250M9k0Z2JU0k1yRElgxJaF0tEQRYchjnH" +
       "svMZAEMtaFHYeplDhRIy65D6GisXlxNrKhbrqVhiDQPtoqZ1EPAQT6KVsBBy" +
       "ZJ28RmnQpWIertZ4xKC6oSAARZcG8GBIia3SEG6VbOtzYsGZ2zYm5iWCyHNU" +
       "icSB/64MqYRDWqQ0KSklEVEMxB7ja26TBx68OihJDHgAB2zAPHbpp+dMLHny" +
       "iAEzVACzsHGtEtEbInsae706rGrc6XmGCqpaDBbfMXNU/lp6UtmeZIY10KQI" +
       "D8szD59c9NzyzQ8pHwSl7tVSfkSNp1uYHvWJqC3JWFxJnacklBSYSLXUTUlE" +
       "q/B5tVTA7mtiCcXoXdjUpCl6tRSKY1e+ij8zETUxEiCiAnYfSzSpmfukrDfj" +
       "fXtSon892P9hkhSSqa3TpTVzzlhZpympuYyKtnKOGkm3KMyAV9YlYiv1ZkWL" +
       "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" +
       "3/fu2fPVZVtPC0IK2aUNtJvxX2TBLUhDJWjLw7cOL9zx7nUYkybu/GAWhoqs" +
       "uS4zpM3Dt796412b6zJufqJgaYKGY3JOqJwmstFrQtczHsqE4R9ciS1aDYu1" +
       "pPd8/vta9BI9sayWsUddGsz7IGvThpHNydQEYqZdxJTmytqQoD3oHas5ueus" +
       "Nw49amZtg7nk0vJP059/KO+VpSvvNozLthu0J1SwobYVp6gqVuI1J6MohhNb" +
       "Z06sJ0ysmIohLdQ22icmGe7ldrF7yYPbcWzHpWERkfmNplhCjuMoS3UpUKu5" +
       "/ThbnRYWCNqoaqVcvePa78q37QjaSnujXNU1O45tJj0pWDEz9RsFMeb+975N" +
       "+x/YtNUw077OQtW5iXTLI2+cfLH8jnefF1RDupkaBl1FzkDoFnPpfxZsrT4+" +
       "/14MhEUQTDCdZNEEPAJ2VSecXYUxzVRbnNpP4bIHyigYlc0lmyQykEtc3pOi" +
       "uWVY00Se4jLesB5C+G1OrFMJ+nIRFoJuN0bbYeINAbzRpFCXUKsKFGufn2LB" +
       "5S647DQ1Cv3zPbgKcLmPk84M0SyvFEin3fUWYHG6UdNtddhlY5c+deVg7TpD" +
       "X8aZ+qK06+XoSAiVx3vzWN7UQr3sRjTeUKOsoRp1ZdFfA0hdCnu/AUBahmoX" +
       "mnOSMuGa/RB4g9oXdKnp+8lvk9/bSDjvx3HeA1iGaK9AzqZ0pL97yRoifU6/" +
       "q7Hp8nMOo+H2RimjVS025D3G6TQJqWyxE8757kS4yA2R4/tuODLy/aX9sCie" +
       "WU97uesCOVnJl7cgqWf9XQreeup3A1e/micF50rd46ocnStjpVDqpjen2DzV" +
       "eLQ9SWExsL4rBEcpY/+WZfXIFOxAC96h9ig8PYAafjBjWYc7aFk1CLnLlv7v" +
       "1m0p+SHsuhcuL0sBiUvR+gJXY8ne0tQ2uFK0P2RN0UyKMEVpEFGKUrua91ev" +
       "c/4KsfoTtCzCIn9lBTXLeQwUDRnxcq2XmXiDAe8UgtepbeJZ/QvCb8EMCu6u" +
       "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" +
       "upgYKKS2gF/dCLe6iLWCoLuKsHxWd5Vo");
    public static final String jlc$ClassType$jif$1 =
      ("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");
    
    public Player(final jif.lang.Principal jif$P,
                  final jif.lang.Principal jif$O) {
        super();
        this.jif$battleships_Player_P = jif$P;
        this.jif$battleships_Player_O = jif$O;
    }
    
    public void jif$invokeDefConstructor() { this.battleships$Player$(); }
    
    private void jif$init() { nextQuery = null; }
    
    public static boolean jif$Instanceof(final jif.lang.Principal jif$P,
                                         final jif.lang.Principal jif$O,
                                         final Object o) {
        if (o instanceof Player) {
            Player c = (Player) o;
            boolean ok = true;
            ok =
              ok &&
                jif.lang.PrincipalUtil.equivalentTo(c.jif$battleships_Player_P,
                                                    jif$P);
            ok =
              ok &&
                jif.lang.PrincipalUtil.equivalentTo(c.jif$battleships_Player_O,
                                                    jif$O);
            return ok;
        }
        return false;
    }
    
    public static Player jif$cast$battleships_Player(
      final jif.lang.Principal jif$P, final jif.lang.Principal jif$O,
      final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(jif$P, jif$O, o)) return (Player) o;
        throw new ClassCastException();
    }
    
    private final jif.lang.Principal jif$battleships_Player_P;
    private final jif.lang.Principal jif$battleships_Player_O;
    public static final String jlc$CompilerVersion$jl = "2.7.1";
    public static final long jlc$SourceLastModified$jl = 1492411775999L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAM28Wcz0WHYYVt0z0z2bZpM11jIj/Rm1J93iqLkUi6yaztjm" +
       "XsV9KZJFzkgdrkWyuC9VRU7GkA3YkpfI20ixEUsIAgWJnZGcGHCCwDDiIHBi" +
       "QXaAJEIcP9gWAgdx4ujBD0lenCis+v6t//6nEzmGYwK899ZdDs892z3nwz3f" +
       "d35z8ZGuXTyqq3w85lX/dj/WUfe26rVdFFK513X7uePd4OcA8Nv/xk9+5i99" +
       "aPFpd/HptDR6r08Dqir76Nq7i08WUeFHbUeEYRS6i8+WURQaUZt6eTrNE6vS" +
       "XXyuS4+l1w9t1OlRV+Xn28TPdUMdtfdvPukUF58MqrLr2yHoq7brF58RM+/s" +
       "gUOf5qCYdv074uK1OI3ysGsWv2/xirj4SJx7x3ni58UnuwDvEEH21j9P/3g6" +
       "o9nGXhA9WfLhU1qG/eJHXlzxdMdvCPOEeenrRdQn1dNPfbj05o7F5x5Qyr3y" +
       "CBp9m5bHeepHqmH+Sr/4we8KdJ700doLTt4xerdffP+L89SHoXnWx+5kuS3p" +
       "F9/34rQ7pGu7+MEXePYct35T/ld+9pvltnz1jnMYBfkN/4/Mi374hUV6FEdt" +
       "VAbRw8JP/pj4897n/+rPvLpYzJO/74XJD3P+43/tH//er/zwX/sbD3N+6CVz" +
       "FD+Lgv7d4Jf8T/3XX6De2nzohsZH66pLb6Lwnp3fuao+HnnnWs+y+PmnEG+D" +
       "bz8Z/Gv6f+H81F+I/tGri4/vFq8FVT4Us1R9NqiKOs2jlovKqPX6KNwtPhaV" +
       "IXUf3y1en9tiWkYPvUocd1G/W3w4v3e9Vt1/zySKZxA3En14bqdlXD1p116f" +
       "3NvXevH4+eT8fmGx+LD3uDb7xZH+6jfMLmrZGUr3DboKhiIq++4bZpl+o0+i" +
       "Lu2+kRZ1Ht1679rwDd/r+3luktbdN8hn7Uf8jv1G1wbvGVdzb4zat7M0rv/5" +
       "fep62/X3XF55ZWbIF140DvmsSdsqD6P23eDbA8n8419599defaoej+k1a8lz" +
       "oN9+AL145ZU7yN9x058H/s7cOc1aPyv2J98yfoL/V3/mSx+aBau+fHim723q" +
       "Gy+K+TPjsJtb3iy77waf/ul/+L//xZ//VvVM4PvFG+/Tw/evvOnRl17cXlsF" +
       "UTjbqWfgf+yR95ff/avfeuPVm1B8bDZPvTcL0KzrP/ziN96jT+88sU03krwq" +
       "Lj4RV23h5behJwbl433SVpdnPXe6f+Le/tRvzc8r8/t/3d6b6N06bvVMWuqx" +
       "2D96Kvf94qz+D3/oT331n5OAfBVG119B0B9H1vWDrNy4+gIl7/b3a0b9C//9" +
       "f/U/L1+9UeCJqf70czbdiPp3njMPN2CfvBuCzz4Tkn0bRfO8v/tn1D/9c7/5" +
       "01+/S8g840df9sE3buWNPt5Ml6r9g3+j+Tt//+/90q+/+kyq+sVr9eDnaXDH" +
       "/AszoC8/+9RsOfLZes2YdG+YZVGFaZx6fh7dJPSffPp3wX/5f/3ZzzyIWT73" +
       "PDCtXXzl/xnAs/4fIBc/9Ws/+X/88B3MK8Ht5HpGjmfTHszh9z6DTLStN97w" +
       "uP7+/+aLf/a/9H5hNqyzMevSKbrbp1fv23v1Lj2fm4VkZtPbtzNqFum0DNLa" +
       "ux8DP37f9Vfus/7lewnchOq+dnEfg27FD13vY9937/9Y9/6jg72dwc90xAW/" +
       "8+d+kPrd/+i+qWc6coPxg9f3GxHLe059kb9Q/G+vfum1v/7q4nV38Zn78e+V" +
       "veXlw43r7nyAd9TjTnHxPe8Zf+9h/HDyvPPUBnzhRf187rMvaucz4zW3b7Nv" +
       "7defV8jH1n/xe+f3S4vFR/71x7VzG/1MfSs/e31lcW9g9yU/ci+/dCt+1xPZ" +
       "e71u0/OssdenQO+U/8RjYIfHtfYc0H7xEb/y2vAJZz/7vGUlbyMPKngrkadg" +
       "P3cD+3vm963F4jX2cf0DL8H193wXXG/Nrz7oyKyyVV1X5Ww1tGF27KLuCS7f" +
       "c5Oyx5b8QR9exONOM3J+v71YfN8fflwbL8GDfcDjVmzeT5zbKv1xLbyHOB8r" +
       "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" +
       "VjvR3Or28eSUmyiJ19E2pPDZvQciF7UD");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "WzxOAXh21X1xu7H6xe+WW3W/rfpLf+Dbvxgq/w786uPl7/aLj/VV/eN5dI7y" +
       "50B9Yob0Iy9Aku75ZM+uvv956Tu/yn05+FOvLj709Nb6+9LS3rvonffeVf94" +
       "G/VDW+7fc2P9B57en75dnV587/wCi8VrX39cv+f29TP6369e/+h7r15//PES" +
       "/XEtPrf0A3IIft8HjP3UrRhniXuOZW88sOyNZ8hc3ovHF+YXWSxe/x0P9Wv/" +
       "5H1buBX1C5995XEe0e331x9fSL5VP9kvPpSW/X3hH/wAVP/IrfgD/S0rLL1f" +
       "bv/ay3C7kfcbi8X3/LHH9bd+O7jdod5n/fEPQORP3oo/1i8+3vVVG5FPswFe" +
       "2NSHz1UavgzF3z2/0WLxqW8+rol/OhT/7Aeg+G/eip/vF5+MyrBqu+hpYsJL" +
       "afa1+a0Wi0//L4/r//C3i5Bwn/VvfQBC//at+IVnCN1TBO5LX0DoriM/Nr/T" +
       "YvHZv/W4/pXfno7clvzy4/rf/X+nI3/+A8b+/VvxSzPux6iXn6Q3vAz3+5I3" +
       "5/fPLRaf/+XH9R/+pyPmf/AB2vO5fvGlZ9kHuzyPjl5OtMd7fhlzDaL6lrN0" +
       "B/OXbsUvz7jXt1S6rnuWmvGCtL7uV1UeeeULW3r9tqUv3768eHjudb/4u+/P" +
       "env05v8/SW9vffVRM3hd2gxVH735kE326KZ7j25HUVqeq1NER/FzKYdvvvXo" +
       "m32Sdm+/xOi9+dY733qrrr+7lN2f116kyG30r9QvcvV5KfpPP2DsP7sV/8nj" +
       "w/NlGN/G//QLrPnobfln38+aX/8XljUPyVbP8ybtb7x49PXo7OVvPk0d+qZX" +
       "+N969LVH5ZDnb73zE8ajl3Fk816OvP4yjvz1D+TIr37A2K/div+8X3z0CZ4v" +
       "48D94198Hwde5f5F5cBD1tSjxzryWOPvrHji0FTxm1+/p1Tdeu98uBuZh9bT" +
       "3MUHBt3WqV959NuZrjydPpuvF+c/ZAw+TK5+gp0FI40fvVk9Sp/i9uhhizeR" +
       "eWg9CmYxefNxb/XO0y1Vp7l/1p3onXtrLr785Ufvz8E0bzlNUTPMcpnPJN9X" +
       "bwZvfzf/+Cv37b71zwygcgeovPXOg884g3znW4+bsZd30fvM0Eud7y/fCu05" +
       "z/mZOH/oWcbc3e/+8ZdkwT2Q/L78v/0Abfjbt+Jv9YtPvVdUbr3/0fM68SQr" +
       "+vuf6MKTjtvoF/8Zb+dW/Pp96t/7ANR/41b8nX7xQzfUA6/rX8KLO1bXfvHa" +
       "w89bqu/3v++/cDz8r4jgV37x0x/9nb9o/u17/vnT/+fwmrj4aDxbq+fzVp9r" +
       "v1a3UZze8XntIYv1gRT/oF984jl0bl3/Y/2wr/8boGp5TQ5EAAA=");
}
