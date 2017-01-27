package actions;

public interface Reaction2<Return, Type1, Type2> {

    Return run(Type1 type1, Type2 type2);

}
