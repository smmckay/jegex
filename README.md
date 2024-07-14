# jegex

---

Jegex (pronounced "jegex") is a Java library for regular languages. It has 
the following goals, in no particular order:

1. Provide a drop-in replacement for `java.util.Pattern` with higher 
   performance and 100% compatibility with the subset of regular expressions 
   supported by both libraries.
2. Parse all input in O(1) time by use of
   [DFAs](https://en.wikipedia.org/wiki/Deterministic_finite_automaton).
3. Demonstrate the trade-offs involved in different approaches to 
   compilation, with comprehensive benchmarks of multiple DFA implementations.
4. Investigate alternative syntax for descriptions of regular languages.