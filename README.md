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

### break up into multiple files
Clojure must have more sophisticated code organization techniques than "just
shove everything into a file."  I need to figure out what they use instead of
objects for organizing functions.

### string concatenation
There must be a more sophisticated tool than join for constructing strings.
Even java string formatting is better.

### streaming
println the pretty-print as we go instead of concatting with newlines

### generate a tree diagram
svg or pic might be useful

### finish video
I need to finish watching the video--I suspect that clojure has a better way of
augmenting maps than what I did.

[0]: https://www.youtube.com/watch?v=j649Tr25RyA
