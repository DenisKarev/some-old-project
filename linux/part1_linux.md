### Задание 1
 
1.  Используйте команды операционной системы Linux и создайте две новых директории – «Игрушки для школьников» и «Игрушки для дошколят»
2.  Создайте в директории «Игрушки для школьников» текстовые файлы - «Роботы», «Конструктор», «Настольные игры»
3.  Создайте в директории «Игрушки для дошколят» текстовые файлы «Мягкие игрушки», «Куклы», «Машинки»
4.  Объединить 2 директории в одну «Имя Игрушки»
5.  Переименовать директорию «Имя Игрушки» в «Игрушки»
6.  Просмотреть содержимое каталога «Игрушки».
7.  Установить и удалить snap-пакет. (Любой, какой хотите)
8.  Добавить произвольную задачу для выполнения каждые 3 минуты (Например, запись в текстовый файл чего-то или копирование из каталога А в каталог Б).

    
```bash
#!/bin/bash
#1
mkdir 'Игрушки для школьников' 'Игрушки для дошколят'

#2
cd ./'Игрушки для школьников'/
touch 'Роботы' 'Конструктор' 'Настольные игры'
cd ..

#3
cd ./'Игрушки для дошколят'/
touch 'Мягкие игрушки' 'Куклы' 'Машинки'
cd ..

#4
mkdir 'Имя Игрушки'
mv 'Игрушки для школьников' 'Имя Игрушки'
mv 'Игрушки для дошколят' 'Имя Игрушки'

#5
mv 'Имя Игрушки' 'Игрушки'

#6
ls 'Игрушки'/

#7
sudo snap install gedit
sudo snap remove gedit
```
![ls dir](./p1images/IA_p2_linux_ls.png)
#### или
![tree dir](./p1images/IA_p2_linux_tree.png)
```bash
#8
crontab -e
# добавить задачу 
*/3 * * * * echo 'some text' >> ~/tmp/cronfile
# сохранить/выйти ))
```
![crontab file](./p1images/IA_p2_linux_crontab.png)
