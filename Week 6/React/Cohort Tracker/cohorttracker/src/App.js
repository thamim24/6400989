import React from 'react';
import CohortDetails from './components/CohortDetails';
import { cohortData } from './data/cohortData';

const App = () => {
  return (
    <div className="app-container">
      <h1 className="app-title">Cohorts Details</h1>
      <div className="cohorts-container">
        {cohortData.map(cohort => (
          <CohortDetails key={cohort.id} cohort={cohort} />
        ))}
      </div>
    </div>
  );
};
export default App;