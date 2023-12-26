package types;

public interface Lexing {
  public enum TokenType {
    kwStop,
    kwSet,
    kwPrint,

    integer,
    string,
    bool,
    identifier,

    equal,
    exclamationMarkEqual,
    less,
    lessEqual,
    greater,
    greaterEqual,

    semicolon,
    assign,
    parenthesesOpen,
    parenthesesClosed,
    curlyBracketOpen,
    curlyBracketClosed,
    plus,
    minus,
    asterisk,
    slash,
    exclamationMark,
    ampersand,
    pipe,
    backslash,
    tilde
  }

  public record Token(
    TokenType type,
    String value,
    int row,
    int column
  ) {} 
}