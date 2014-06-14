## Dendrology Experiments
This currently has two exercises from Brandon Bloom's talk on [Dendrology][0],
one pretty-printing trees, and the other doing an in-order numbering of the tree

## Experimenting with clojure
I've read the joy of clojure, but I wasn't interested enough to ever actually
touch it, so this is my first real foray.  For this reason, the code is quite
ugly, and not at all idiomatic.

## Next Steps

### recur
Since clojure doesn't automatically do tail call elimination, I need to
understand how recur works and restructure all of my recursive methods to use
that.

### generate a tree diagram
svg or pic might be useful

### functional bfs
Apparently this is simple with zippers.  Another way to do it would seemingly be
to just pass a queue of nodes, so let's try both ways.

[0]: https://www.youtube.com/watch?v=j649Tr25RyA
