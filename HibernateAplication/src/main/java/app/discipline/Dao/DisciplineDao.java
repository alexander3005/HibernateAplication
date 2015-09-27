package app.discipline.Dao;

import app.discipline.Model.Discipline;

import java.util.List;

/**
 * Created by Acer on 18.09.2015.
 */
public interface DisciplineDao {
    public void addDiscipline(Discipline discipline);
    public List<Discipline> listDiscipline();
    public Discipline getById(int id);
    public void update(Discipline discipline);
    public void delete(int id);
}