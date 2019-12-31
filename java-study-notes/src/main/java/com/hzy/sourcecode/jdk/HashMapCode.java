package com.hzy.sourcecode.jdk;


import java.util.HashMap;
import java.util.Map;

/**
 * Hash table based implementation of the <tt>Map</tt> interface. This
 * implementation provides all of the optional map operations, and permits
 * <tt>null</tt> values and the <tt>null</tt> key. (The <tt>HashMap</tt>
 * class is roughly equivalent to <tt>Hashtable</tt>, except that it is
 * unsynchronized and permits nulls.) This class makes no guarantees as to
 * the order of the map; in particular, it does not guarantee that the order
 * will remain constant over time.
 * HashTable 实现了 map 接口的所有操作 并且限制 key 和 value 不能为null
 * hashmap 与 hashtable 大致等价，除了 非线程安全 和 允许 null 值。
 * hashmap 不能保证map的有序性，尤其是不能保证顺序不会随时间而保持不变
 *
 * <p>This implementation provides constant-time performance for the basic
 * operations (<tt>get</tt> and <tt>put</tt>), assuming the hash function
 * disperses the elements properly among the buckets. Iteration over
 * collection views requires time proportional to the "capacity" of the
 * <tt>HashMap</tt> instance (the number of buckets) plus its size (the number
 * of key-value mappings). Thus, it's very important not to set the initial
 * capacity too high (or the load factor too low) if iteration performance is
 * important.
 * 假设 hash 方法将元素适当的分散到各个桶中，则这种实现会为基本操作（读写）提供恒定的时间性能
 * 集合视图的迭代所需要的时间与hashmap实例的容量（桶bucket数量）加上每个桶的大小（键值对的数量）是成比例的
 * 因此如果看重迭代性能的化，不要设置初始容量太大或者负载因子太小
 *
 * <p>An instance of <tt>HashMap</tt> has two parameters that affect its
 * performance: <i>initial capacity</i> and <i>load factor</i>. The
 * <i>capacity</i> is the number of buckets in the hash table, and the initial
 * capacity is simply the capacity at the time the hash table is created. The
 * <i>load factor</i> is a measure of how full the hash table is allowed to
 * get before its capacity is automatically increased. When the number of
 * entries in the hash table exceeds the product of the load factor and the
 * current capacity, the hash table is <i>rehashed</i> (that is, internal data
 * structures are rebuilt) so that the hash table has approximately twice the
 * number of buckets.
 * 一个hashmap的实例中有两个参数会影响其性能，初始化容量和负载因子
 * 容量是hash表中桶的数量，初始化容量就是hash表创建时的容量。
 * 负载因子时hash表在容量自动扩充之前，hash表所允许到达的最大容量的度量
 * 当hash表中的实体数量超过负载因子和当前容量的乘积时，hash表会进行 rehash 操作
 * 即 内部数据结构会被重建，这样hash表中桶的数量大约是原来的两倍
 *
 * <p>As a general rule, the default load factor (.75) offers a good
 * tradeoff between time and space costs. Higher values decrease the
 * space overhead but increase the lookup cost (reflected in most of
 * the operations of the <tt>HashMap</tt> class, including
 * <tt>get</tt> and <tt>put</tt>). The expected number of entries in
 * the map and its load factor should be taken into account when
 * setting its initial capacity, so as to minimize the number of
 * rehash operations. If the initial capacity is greater than the
 * maximum number of entries divided by the load factor, no rehash
 * operations will ever occur.
 * 一般来说，默认的负载因子 0.75 在时间和空间成本上提供了很好的权衡
 * 如果使用更大的值，虽然减少了空间开销，但是增加了查找成本，会反映在hashmap类中的大多数操作中包括 get 和 set
 * 在设置初始化容量时，应该考虑到预期的map中的条目数量和他的负载因子，来最小化rehash操作的数量
 * 如果初始化容量大于 entry除以负载因子 的数量，就不会出现 rehash
 *
 * <p>If many mappings are to be stored in a <tt>HashMap</tt>
 * instance, creating it with a sufficiently large capacity will allow
 * the mappings to be stored more efficiently than letting it perform
 * automatic rehashing as needed to grow the table. Note that using
 * many keys with the same {@code hashCode()} is a sure way to slow
 * down performance of any hash table. To ameliorate impact, when keys
 * are {@link Comparable}, this class may use comparison order among
 * keys to help break ties.
 * 如果有很多的键值对需要存放到hashmap实例中，创建一个足够大的容量的hashmap将会使得键值对的存放
 * 相比于让他根据需要自动rehash扩容增长会更加高效
 * 注意：使用具有相同 hashcode 的多个键肯定会拖慢任何哈希表的性能
 * 为了减轻碰撞，当键有可比性时，可以通过键之间的比较顺序来 打破关系
 *
 * <p><strong>Note that this implementation is not synchronized.</strong>
 * If multiple threads access a hash map concurrently, and at least one of
 * the threads modifies the map structurally, it <i>must</i> be
 * synchronized externally. (A structural modification is any operation
 * that adds or deletes one or more mappings; merely changing the value
 * associated with a key that an instance already contains is not a
 * structural modification.) This is typically accomplished by
 * synchronizing on some object that naturally encapsulates the map.
 * 注意：hashmap 是非线程安全的
 * 如果多个线程并发使用 hashmap 并且至少一个线程修改 hashmap的结构，则必须在外部加锁同步处理
 * （结构修改指的是，任何添加或删除一个或多个KV映射，如果修改已有的 KV 不属于结构修改）
 * 通常可以使用synchronized锁定某个object实现map同步
 *
 * If no such object exists, the map should be "wrapped" using the
 * { Collections#synchronizedMap Collections.synchronizedMap}
 * method. This is best done at creation time, to prevent accidental
 * unsynchronized access to the map:<pre>
 * Map m = Collections.synchronizedMap(new HashMap(...));</pre>
 * 如果不存在这样一个对象，则 map 可以通过使用 collections工具类的synchronizedMap方法创建hashmap
 * Map m = Collections.synchronizedMap(new HashMap(...));
 *
 * <p>The iterators returned by all of this class's "collection view methods"
 * are <i>fail-fast</i>: if the map is structurally modified at any time after
 * the iterator is created, in any way except through the iterator's own
 * <tt>remove</tt> method, the iterator will throw a
 * { ConcurrentModificationException}. Thus, in the face of concurrent
 * modification, the iterator fails quickly and cleanly, rather than risking
 * arbitrary, non-deterministic behavior at an undetermined time in the
 * future.
 * 当迭代器创建之后，任何对hashmap结构性的改变操作都会引起迭代器抛出并发修改该异常。除非使用迭代器自己的remove方法
 * 当出现并发修改异常后会简单快速明了的抛出异常，而不会冒险在以后不确定的时间抛出
 *
 * <p>Note that the fail-fast behavior of an iterator cannot be guaranteed
 * as it is, generally speaking, impossible to make any hard guarantees in the
 * presence of unsynchronized concurrent modification. Fail-fast iterators
 * throw <tt>ConcurrentModificationException</tt> on a best-effort basis.
 * Therefore, it would be wrong to write a program that depended on this
 * exception for its correctness: <i>the fail-fast behavior of iterators
 * should be used only to detect bugs.</i>
 * 需要注意：迭代器快速失败的行为并不能得到保证。通常来说，非同步的并发修改中很难做出有力的保证。
 * 快速失败的迭代器只能是尽最大努力的抛出并发修改异常，因此，如果依赖于这个异常进行编程是错误的
 * 他仅仅时用于检测程序的错误
 *
 * <p>This class is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 *  <K> the type of keys maintained by this map
 *  <V> the type of mapped values
 *
 * @author Doug Lea
 * @author Josh Bloch
 * @author Arthur van Hoff
 * @author Neal Gafter
 * @see Object#hashCode()
 * @since 1.2
 */
public class HashMapCode {

/*
     * Implementation notes.  实现的注意事项
     *
     * This map usually acts as a binned (bucketed) hash table, but
     * when bins get too large, they are transformed into bins of
     * TreeNodes, each structured similarly to those in
     * java.util.TreeMap. Most methods try to use normal bins, but
     * relay to TreeNode methods dang (simply by checking
     * instanceof a node).  Bins of TreeNodes may be traversed and
     * used like any others, but additionally support faster lookup
     * when overpopulated. However, since the vast majority of bins in
     * normal use are not overpopulated, checking for existence of
     * tree bins may be delayed in the course of table methods.
     *
     * 通常，hashmap 是以一个 桶binned(bucketed) 的概念为基础的 hash表
     * 但是当 桶 中的 bin 容量过大时，他会转换为 以 TreeNode 为结构的桶（该结构与 treemap 相似）
     * 大多数方法尝试使用常规的 bins ,但是当需要使用的时候，会转为 treenode（仅仅检查是不是node实例）
     * treenode可以像其他形式一样被遍历和使用，但是当元素密集时，支持额外的更快速查找
     * 然而，通常情况下 bins 不会过于密集。表中tree bin的使用会被延迟
     *
     * Tree bins (i.e., bins whose elements are all TreeNodes) are
     * ordered primarily by hashCode, but in the case of ties, if two
     * elements are of the same "class C implements Comparable<C>",
     * type then their compareTo method is used for ordering. (We
     * conservatively check generic types via reflection to validate
     * this -- see method comparableClassFor).  The added complexity
     * of tree bins is worthwhile in providing worst-case O(log n)
     * operations when keys either have distinct hashes or are
     * orderable, Thus, performance degrades gracefully under
     * accidental or malicious usages in which hashCode() methods
     * return values that are poorly distributed, as well as those in
     * which many keys share a hashCode, so long as they are also
     * Comparable. (If neither of these apply, we may waste about a
     * factor of two in time and space compared to taking no
     * precautions. But the only known cases stem from poor user
     * programming practices that are already so slow that this makes
     * little difference.)
     *
     * Because TreeNodes are about twice the size of regular nodes, we
     * use them only when bins contain enough nodes to warrant use
     * (see TREEIFY_THRESHOLD). And when they become too small (due to
     * removal or resizing) they are converted back to plain bins.  In
     * usages with well-distributed user hashCodes, tree bins are
     * rarely used.  Ideally, under random hashCodes, the frequency of
     * nodes in bins follows a Poisson distribution
     * (http://en.wikipedia.org/wiki/Poisson_distribution) with a
     * parameter of about 0.5 on average for the default resizing
     * threshold of 0.75, although with a large variance because of
     * resizing granularity. Ignoring variance, the expected
     * occurrences of list size k are (exp(-0.5) * pow(0.5, k) /
     * factorial(k)). The first values are:
     *
     * 0:    0.60653066
     * 1:    0.30326533
     * 2:    0.07581633
     * 3:    0.01263606
     * 4:    0.00157952
     * 5:    0.00015795
     * 6:    0.00001316
     * 7:    0.00000094
     * 8:    0.00000006
     * more: less than 1 in ten million
     *
     * The root of a tree bin is normally its first node.  However,
     * sometimes (currently only upon Iterator.remove), the root might
     * be elsewhere, but can be recovered following parent links
     * (method TreeNode.root()).
     *
     * All applicable internal methods accept a hash code as an
     * argument (as normally supplied from a public method), allowing
     * them to call each other without recomputing user hashCodes.
     * Most internal methods also accept a "tab" argument, that is
     * normally the current table, but may be a new or old one when
     * resizing or converting.
     *
     * When bin lists are treeified, split, or untreeified, we keep
     * them in the same relative access/traversal order (i.e., field
     * Node.next) to better preserve locality, and to slightly
     * simplify handling of splits and traversals that invoke
     * iterator.remove. When using comparators on insertion, to keep a
     * total ordering (or as close as is required here) across
     * rebalancings, we compare classes and identityHashCodes as
     * tie-breakers.
     *
     * The use and transitions among plain vs tree modes is
     * complicated by the existence of subclass LinkedHashMap. See
     * below for hook methods defined to be invoked upon insertion,
     * removal and access that allow LinkedHashMap internals to
     * otherwise remain independent of these mechanics. (This also
     * requires that a map instance be passed to some utility methods
     * that may create new nodes.)
     *
     * The concurrent-programming-like SSA-based coding style helps
     * avoid aliasing errors amid all of the twisty pointer operations.
     */

    /**
     * The default initial capacity - MUST be a power of two.
     * 默认的容量 是 16 ，并且 必须是 2 的 n 次幂
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     * 最大 2 的 30 次
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * The load factor used when none specified in constructor.
     * 大于 0 ，负载因子
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * The bin count threshold for using a tree rather than list for a
     * bin.  Bins are converted to trees when adding an element to a
     * bin with at least this many nodes. The value must be greater
     * than 2 and should be at least 8 to mesh with assumptions in
     * tree removal about conversion back to plain bins upon
     * shrinkage.
     * 转化为 树的 最小长度 8
     */
    static final int TREEIFY_THRESHOLD = 8;

    /**
     * The bin count threshold for untreeifying a (split) bin during a
     * resize operation. Should be less than TREEIFY_THRESHOLD, and at
     * most 6 to mesh with shrinkage detection under removal.
     * 树 转链表 的最小 6
     */
    static final int UNTREEIFY_THRESHOLD = 6;

    /**
     * The smallest table capacity for which bins may be treeified.
     * (Otherwise the table is resized if too many nodes in a bin.)
     * Should be at least 4 * TREEIFY_THRESHOLD to avoid conflicts
     * between resizing and treeification thresholds.
     * 链表转 树 的 容量最小
     */
    static final int MIN_TREEIFY_CAPACITY = 64;

    /**
     * Basic hash bin node, used for most entries.  (See below for
     * TreeNode subclass, and in LinkedHashMap for its Entry subclass.)
     */
//    static class Node<K,V> implements Map.Entry<K,V> {
//        final int hash;
//        final K key;
//        V value;
//        HashMap.Node<K,V> next;
//
//        Node(int hash, K key, V value, HashMap.Node<K,V> next) {
//            this.hash = hash;
//            this.key = key;
//            this.value = value;
//            this.next = next;
//        }
//
//        public final K getKey()        { return key; }
//        public final V getValue()      { return value; }
//        public final String toString() { return key + "=" + value; }
//
//        public final int hashCode() {
//            return Objects.hashCode(key) ^ Objects.hashCode(value);
//        }
//
//        public final V setValue(V newValue) {
//            V oldValue = value;
//            value = newValue;
//            return oldValue;
//        }
//
//        public final boolean equals(Object o) {
//            if (o == this)
//                return true;
//            if (o instanceof Map.Entry) {
//                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
//                if (Objects.equals(key, e.getKey()) &&
//                        Objects.equals(value, e.getValue()))
//                    return true;
//            }
//            return false;
//        }
//    }


    public static void main(String[] args) {

//        System.out.println(1 << 30);
//        int n = 1;
//        n |= n >>> 1;
        System.out.println(tableSizeFor(5));
        System.out.println(tableSizeFor(73));
//        System.out.println(n);

        Map map = new HashMap(2);
        map.put("testKey1","testValue1");
        System.out.println();
//        map.put("testKey2","testValue2");
//        map.put("testKey1","testValue1New");
    }

    /**
     * Returns a power of two size for the given target capacity.
     */
    static final int tableSizeFor(int cap) {
        System.out.println("===========");
        int n = cap - 1;
        System.out.println("======"+n+"=====");
        n |= n >>> 1;
        System.out.println("======"+n+"=====");
        n |= n >>> 2;
        System.out.println("======"+n+"=====");
        n |= n >>> 4;
        System.out.println("======"+n+"=====");
        n |= n >>> 8;
        System.out.println("======"+n+"=====");
        n |= n >>> 16;
        System.out.println("======"+n+"=====");
        System.out.println("===========");
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
