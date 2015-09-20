package app.discipline.Services;

import app.discipline.Dao.DisciplineDao;
import app.discipline.Model.Discipline;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Acer on 18.09.2015.
 */
@Service
public class DisciplineServicesImpl  implements  DisciplineServices{

    private DisciplineDao disciplineDao;

    public void setDisciplineDao(DisciplineDao disciplineDao) {
        this.disciplineDao = disciplineDao;
    }

    @Override
    @Transactional
    public void addDiscipline(Discipline discipline) {
        this.disciplineDao.addDiscipline(discipline);
    }

    @Override
    @Transactional
    public List<Discipline> listDiscipline() {
        return this.disciplineDao.listDiscipline();
    }

    @Override
    @Transactional
    public Discipline getById(int id) {
        return this.disciplineDao.getById(id);
    }

    @Override
    @Transactional
    public void update(Discipline discipline) {
         this.disciplineDao.update(discipline);
    }

    @Override
    @Transactional
    public void delete(int id) {
       this.disciplineDao.delete(id);
    }
}
