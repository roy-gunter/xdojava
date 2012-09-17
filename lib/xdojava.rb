module SageoneNaUtils
  class XdoJava
    # Types a character sequence, but without any special chars.
    def self.type_keys(type_this)
      #command_line = 'java -classpath ' + get_classpath + ' xdojava ' + type_this
      command_line = 'java xdojava ' + type_this
      system(command_line)
      sleep(0.5)
    end

    def self.tab
      #command_line = 'java -classpath ' + get_classpath + ' xdojava  {TAB}'
      command_line = 'java xdojava  {TAB}'
      system(command_line)
    end

    def self.tab_back
      #command_line = 'java -classpath ' + get_classpath + ' xdojava  {SHIFT_TAB}'
      command_line = 'java xdojava  {SHIFT_TAB}'
      system(command_line)
    end
  end
end
